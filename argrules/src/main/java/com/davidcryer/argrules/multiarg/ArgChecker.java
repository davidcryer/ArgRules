package com.davidcryer.argrules.multiarg;

public abstract class ArgChecker<E extends BrokenRulesException, R extends Results<E>> {

    public void check() throws E {
        results().ensurePassed(Throw::throwable);
    }

    protected abstract R results();
}
