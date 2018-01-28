package com.davidcryer.argrules.singlearg;

public class Enforce {

    public static void isSatisfied(final boolean condition, final String error) throws IllegalArgumentException {
        if (!condition) {
            throw new IllegalArgumentException(error);
        }
    }
}
