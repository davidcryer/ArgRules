package com.davidcryer.argrules;

import org.junit.Test;

public class TestRulesTest {

    @Test
    public void practice() {
        new RulesTestTest().firstRule(firstRule()).secondRule(secondRule()).run();
    }

    private Rule firstRule() {
        return new Rule(true, "what");
    }

    private Rule secondRule() {
        return new Rule(true, "umm");
    }
}