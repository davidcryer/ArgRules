package com.davidcryer.argrules.multiarg;

public interface FailedCallback<T> {
    void didFail(T ret);
}
