package com.davidcryer.argrules.multiarg;

import static com.davidcryer.argrules.multiarg.DelayedResult.delayed;
import static com.davidcryer.argrules.multiarg.ImmediateResult.forCheck;
import static com.davidcryer.argrules.multiarg.ResultChain.chain;

class TestArgChecker extends ArgChecker<TestArgResults, TestArgException> {
    private final static String ERROR_FIRST_NULL = "first cannot be null";
    private final static String ERROR_SECOND_NULL = "second cannot be null";
    private final static String ERROR_SECOND_EMPTY = "second cannot be null";
    private final TestArgResults.Builder resultsBuilder = new TestArgResults.Builder();

    private TestArgChecker() {}

    static TestArgChecker fresh() {
        return new TestArgChecker();
    }

    TestArgChecker first(final String first) {
        resultsBuilder.firstResult(forCheck(first != null, ERROR_FIRST_NULL));
        return this;
    }

    TestArgChecker second(final String second) {
        resultsBuilder.secondResult(chain()
                .add(delayed(() -> second != null, ERROR_SECOND_NULL))
                .add(delayed(() -> !second.isEmpty(), ERROR_SECOND_EMPTY))
                .firstFailing()
        );
        return this;
    }

    @Override
    protected TestArgResults results() {
        return resultsBuilder.results();
    }

    @Override
    protected TestArgException exception(TestArgResults results) {
        return new TestArgException(results);
    }
}
