package com.davidcryer.argrules.multiarg.outsidepackage;

import com.davidcryer.argrules.multiarg.BrokenRulesException;

class BrokenTestRulesException extends BrokenRulesException {
    private final TestResults results;

    BrokenTestRulesException(TestResults results) {
        super(results);
        this.results = results;
    }
}
