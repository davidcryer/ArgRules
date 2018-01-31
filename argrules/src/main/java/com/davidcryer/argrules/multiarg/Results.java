package com.davidcryer.argrules.multiarg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Results<E extends ArgException> {

    void ensurePassed(final FailedCallback<E> failedCallback) {
        if (!passed()) {
            failedCallback.didFail(exception());
        }
    }

    private boolean passed() {
        return resultStream().allMatch(Result::passed);
    }

    private Stream<Result> resultStream() {
        return Arrays.stream(asArray());
    }

    protected abstract Result[] asArray();

    protected abstract E exception();

    String[] toMessages() {
        final List<String> messages = resultStream().filter(result -> !result.passed()).map(Result::note).collect(Collectors.toList());
        return messages.toArray(new String[messages.size()]);
    }

    public interface Builder<R extends Results> {
        R results();
    }
}
