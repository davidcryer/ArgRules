package com.davidcryer.argrules.multiarg;

import org.junit.Test;

public class ArgCheckerTest {

    @Test
    public void validTest() {
        TestArgChecker.fresh().first("what?").second("okay...").check();
    }

    @Test(expected = BrokenTestRulesException.class)
    public void invalidTest_nullFirst() throws BrokenTestRulesException {
        TestArgChecker.fresh().first(null).second("not sure about this").check();
    }

    @Test(expected = BrokenTestRulesException.class)
    public void invalidTest_nullSecond() throws BrokenTestRulesException {
        TestArgChecker.fresh().first("Uh oh").second(null).check();
    }
}