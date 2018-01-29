package com.davidcryer.argrules.multiarg.outsidepackage;

import com.davidcryer.argrules.multiarg.RulesTest;

import static com.davidcryer.argrules.multiarg.DelayedResult.delayed;
import static com.davidcryer.argrules.multiarg.ImmediateResult.forCheck;
import static com.davidcryer.argrules.multiarg.ResultChain.chain;

class RulesTestTest extends RulesTest<BrokenTestRulesException, TestResults> {
    private final static String ERROR_FIRST_NULL = "first cannot be null";
    private final static String ERROR_SECOND_NULL = "second cannot be null";
    private final static String ERROR_SECOND_EMPTY = "second cannot be null";
    private final TestResults.Builder resultsBuilder = new TestResults.Builder();

    private RulesTestTest() {}

    static RulesTestTest fresh() {
        return new RulesTestTest();
    }

    RulesTestTest first(final String first) {
        resultsBuilder.firstResult(forCheck(first != null, ERROR_FIRST_NULL));
        return this;
    }

    RulesTestTest second(final String second) {
        resultsBuilder.secondResult(chain()
                .add(delayed(() -> second != null, ERROR_SECOND_NULL))
                .add(delayed(() -> !second.isEmpty(), ERROR_SECOND_EMPTY))
                .firstFailing()
        );
        return this;
    }

    @Override
    protected TestResults results() {
        return resultsBuilder.results();
    }
}
