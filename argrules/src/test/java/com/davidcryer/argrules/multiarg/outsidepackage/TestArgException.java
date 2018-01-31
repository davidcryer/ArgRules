package com.davidcryer.argrules.multiarg.outsidepackage;

import com.davidcryer.argrules.multiarg.ArgException;

class TestArgException extends ArgException {
    private final TestArgResults results;

    TestArgException(TestArgResults results) {
        super(results);
        this.results = results;
    }
}
