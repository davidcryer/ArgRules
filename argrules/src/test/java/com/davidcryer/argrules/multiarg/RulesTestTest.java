package com.davidcryer.argrules.multiarg;

import com.davidcryer.argrules.conditions.Conditions;
import com.davidcryer.argrules.conditions.ObjectCondition;

class RulesTestTest extends RulesTest<BrokenTestRulesException, TestResults, TestResults.Builder> {
    private final static String ERROR_FIRST = "first cannot be null";
    private final static String ERROR_SECOND = "second cannot be null";

    private RulesTestTest() {}

    static RulesTestTest fresh() {
        return new RulesTestTest();
    }

    RulesTestTest first(final String first) {
        add(builder -> builder.firstResult(Result.forCheck(Conditions.isNonNull.passes(first), ERROR_FIRST)));
        return this;
    }

    RulesTestTest second(final String second) {
        add(builder -> builder.secondResult(Result.forCheck(Conditions.isNonNull.passes(second), ERROR_SECOND)));
        return this;
    }

    @Override
    protected TestResults.Builder resultsBuilder() {
        return new TestResults.Builder();
    }
}
