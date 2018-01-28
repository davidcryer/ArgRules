package com.davidcryer.argrules;

public abstract class RulesTest<E extends Results.Exception, R extends Results<E>> {

    public void run() throws E {
        results().checkPassed(Throw::throwable);
    }

    protected abstract R results();
}
