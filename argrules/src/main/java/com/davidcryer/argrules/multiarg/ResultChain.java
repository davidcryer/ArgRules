package com.davidcryer.argrules.multiarg;

import java.util.ArrayList;
import java.util.List;

import static com.davidcryer.argrules.multiarg.ImmediateResult.forSuccess;

public class ResultChain {
    private List<Result> results = new ArrayList<>();

    private ResultChain() {}

    public static ResultChain chain() {
        return new ResultChain();
    }

    public ResultChain add(final Result result) {
        results.add(result);
        return this;
    }

    public Result firstFailing() {
        return firstFailing(null);
    }

    public Result firstFailing(final String noFailedResultNote) {
        return results.stream().filter(result -> !result.passed()).findFirst().orElse(forSuccess(noFailedResultNote));
    }
}
