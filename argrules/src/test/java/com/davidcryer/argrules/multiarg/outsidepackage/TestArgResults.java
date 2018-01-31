package com.davidcryer.argrules.multiarg.outsidepackage;

import com.davidcryer.argrules.multiarg.Result;
import com.davidcryer.argrules.multiarg.ArgResults;

class TestArgResults extends ArgResults {
    private final Result firstResult;
    private final Result secondResult;

    private TestArgResults(Result firstResult, Result secondResult) {
        this.firstResult = firstResult;
        this.secondResult = secondResult;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {firstResult, secondResult};
    }

    static class Builder implements ArgResults.Builder<TestArgResults> {
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
        public TestArgResults results() {
            return new TestArgResults(firstResult, secondResult);
        }
    }
}
