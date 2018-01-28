package com.davidcryer.argrules.multiarg;

import java.util.ArrayList;
import java.util.List;

public abstract class RulesTest<E extends BrokenRulesException, R extends Results<E>, B extends Results.Builder<R>> {
    private final List<TestCase<B>> testCases = new ArrayList<>();

    protected void add(final TestCase<B> testCase) {
        testCases.add(testCase);
    }

    public void run() throws E {
        testCases.stream()
                .reduce(resultsBuilder(), (b, testCase) -> testCase.check(b), (b, b2) -> b2)
                .results()
                .ensurePassed(Throw::throwable);
    }

    protected abstract B resultsBuilder();
}
