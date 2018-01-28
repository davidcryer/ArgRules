package com.davidcryer.argrules.conditions;

import java.util.Collection;

public interface InCollectionCondition {
    boolean passes(final Object o, final Collection c);
}
