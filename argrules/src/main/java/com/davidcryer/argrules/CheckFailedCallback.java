package com.davidcryer.argrules;

public interface CheckFailedCallback<T> {
    void checkFailed(T ret);
}
