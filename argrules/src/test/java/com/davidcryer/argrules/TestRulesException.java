package com.davidcryer.argrules;

class TestRulesException extends BrokenRulesException {
    private final TestResults results;

    TestRulesException(TestResults results) {
        super(results.toMessages());
        this.results = results;
    }
}
