package com.davidcryer.argrules.conditions;

import java.util.Date;

public interface DateCondition {
    boolean passes(final Date date1, final Date date2);
}
