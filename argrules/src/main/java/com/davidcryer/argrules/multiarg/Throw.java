package com.davidcryer.argrules.multiarg;

class Throw {

    static <T extends Throwable> void throwable(final T throwable) throws T {
        throw throwable;
    }
}
