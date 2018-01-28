package com.davidcryer.argrules.multiarg;

class BrokenTestRulesException extends BrokenRulesException {
    private final TestResults results;

    BrokenTestRulesException(TestResults results) {
        super(results.toMessages());
        this.results = results;
    }
}
