package com.davidcryer.argrules.multiarg;

class TestArgException extends ArgException {
    private final TestResults results;

    TestArgException(TestResults results) {
        super(results);
        this.results = results;
    }
}
