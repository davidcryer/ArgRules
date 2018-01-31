package com.davidcryer.argrules.multiarg;

public abstract class ArgChecker<R extends ArgResults, E extends ArgException> {

    public void check() throws E {
        final R results = results();
        if (!results.passed()) {
            Throw.throwable(exception(results));
        }
    }

    protected abstract R results();

    protected abstract E exception(R results);
}
