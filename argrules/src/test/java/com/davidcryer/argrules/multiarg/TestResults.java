package com.davidcryer.argrules.multiarg;

class TestResults extends Results<TestArgException> {
    private final Result firstResult;
    private final Result secondResult;

    private TestResults(Result firstResult, Result secondResult) {
        this.firstResult = firstResult;
        this.secondResult = secondResult;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {firstResult, secondResult};
    }

    @Override
    protected TestArgException exception() {
        return new TestArgException(this);
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
