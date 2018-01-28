package com.davidcryer.argrules;

public abstract class Results<E extends BrokenRulesException> {

    void checkPassed(final CheckFailedCallback<E> failCallback) {
        if (passed()) {
            failCallback.checkFailed(exception());
        }
    }

    protected abstract boolean passed();

    protected abstract E exception();

    protected abstract String[] toMessages();
}
