package com.davidcryer.argrules.multiarg.outsidepackage;

import com.davidcryer.argrules.multiarg.ArgException;

class TestArgException extends ArgException {
    private final TestResults results;

    TestArgException(TestResults results) {
        super(results);
        this.results = results;
    }
}
