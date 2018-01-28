package com.davidcryer.argrules;

public class Enforce {

    public static void isSatisfied(final Rule rule) throws IllegalArgumentException {
        rule.checkSatisfied(error -> Throw.throwable(new IllegalArgumentException(error)));
    }
}
