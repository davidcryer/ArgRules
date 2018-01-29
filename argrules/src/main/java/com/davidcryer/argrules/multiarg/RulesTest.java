package com.davidcryer.argrules.multiarg;

public abstract class RulesTest<E extends BrokenRulesException, R extends Results<E>> {

    public void run() throws E {
        results().ensurePassed(Throw::throwable);
    }

    protected abstract R results();
}
