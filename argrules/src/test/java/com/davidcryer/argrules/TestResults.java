package com.davidcryer.argrules;

class TestResults extends Results<TestRulesException> {
    private final String firstRuleError;
    private final String secondRuleError;

    private TestResults(String firstRuleError, String secondRuleError) {
        this.firstRuleError = firstRuleError;
        this.secondRuleError = secondRuleError;
    }

    public boolean hasFirstRuleError() {
        return firstRuleError != null;
    }

    public boolean hasSecondRuleError() {
        return secondRuleError != null;
    }

    @Override
    protected boolean passed() {
        return hasFirstRuleError() || hasSecondRuleError();
    }

    @Override
    protected TestRulesException exception() {
        return new TestRulesException(this);
    }

    @Override
    protected String[] toMessages() {
        return new String[] {};
    }

    static class Builder {
        private String firstRuleError;
        private String secondRuleError;

        Builder firstRuleError(String firstRuleError) {
            this.firstRuleError = firstRuleError;
            return this;
        }

        Builder secondRuleError(String secondRuleError) {
            this.secondRuleError = secondRuleError;
            return this;
        }

        TestResults results() {
            return new TestResults(firstRuleError, secondRuleError);
        }
    }
}
