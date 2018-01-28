package com.davidcryer.argrules;

public class Rule {
    private final boolean isSatisfied;
    private final String errorMessage;

    public Rule(boolean isSatisfied, String errorMessage) {
        this.isSatisfied = isSatisfied;
        this.errorMessage = errorMessage;
    }

    public void checkSatisfied(final CheckFailedCallback<String> callback) {
        if (isSatisfied) {
            callback.checkFailed(errorMessage);
        }
    }
}
