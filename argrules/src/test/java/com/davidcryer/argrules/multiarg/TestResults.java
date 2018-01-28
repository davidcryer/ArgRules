package com.davidcryer.argrules.multiarg;

class TestResults extends Results<BrokenTestRulesException> {
    private final Result firstResult;
    private final Result secondResult;

    private TestResults(Result firstResult, Result secondResult) {
        this.firstResult = firstResult;
        this.secondResult = secondResult;
    }

    @Override
    protected Result[] results() {
        return new Result[] {firstResult, secondResult};
    }

    @Override
    protected BrokenTestRulesException exception() {
        return new BrokenTestRulesException(this);
    }

    static class Builder implements Results.Builder<TestResults> {
        private Result firstResult;
        private Result secondResult;

        Builder firstResult(Result firstResult) {
            this.firstResult = firstResult;
            return this;
        }

        Builder secondResult(Result secondResult) {
            this.secondResult = secondResult;
            return this;
        }

        @Override
        public TestResults results() {
            return new TestResults(firstResult, secondResult);
        }
    }
}
