package com.davidcryer.argrules.multiarg;

class TestArgException extends ArgException {
    private final TestArgResults results;

    TestArgException(TestArgResults results) {
        super(results);
        this.results = results;
    }
}
