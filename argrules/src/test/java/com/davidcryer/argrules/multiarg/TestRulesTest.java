package com.davidcryer.argrules.multiarg;

import org.junit.Test;

public class TestRulesTest {

    @Test
    public void validTest() {
        RulesTestTest.fresh().first("what?").second("okay...").run();
    }

    @Test(expected = BrokenTestRulesException.class)
    public void invalidTest_nullFirst() throws BrokenTestRulesException {
        RulesTestTest.fresh().first(null).second("not sure about this").run();
    }

    @Test(expected = BrokenTestRulesException.class)
    public void invalidTest_nullSecond() throws BrokenTestRulesException {
        RulesTestTest.fresh().first("Uh oh").second(null).run();
    }
}