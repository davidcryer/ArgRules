package com.davidcryer.argrules;

class RulesTestTest extends RulesTest {
    private final TestResults.Builder resultsBuilder = new TestResults.Builder();

    RulesTestTest firstRule(final Rule firstRule) {
        firstRule.checkSatisfied(resultsBuilder::firstRuleError);
        return this;
    }

    RulesTestTest secondRule(final Rule secondRule) {
        secondRule.checkSatisfied(resultsBuilder::secondRuleError);
        return this;
    }

    @Override
    protected Results results() {
        return resultsBuilder.results();
    }
}
