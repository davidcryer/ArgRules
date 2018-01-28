package com.davidcryer.argrules.multiarg;

public interface TestCase<B extends Results.Builder> {
    B check(B builder);
}
