package com.davidcryer.argrules;

class TestRulesException extends Results.Exception {
    private final TestResults results;

    TestRulesException(TestResults results) {
        super(results.toMessages());
        this.results = results;
    }
}
