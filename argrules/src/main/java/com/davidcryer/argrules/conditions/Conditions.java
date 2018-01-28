package com.davidcryer.argrules.conditions;

import java.util.Objects;

public class Conditions {

    public static ObjectCondition isNull = Objects::isNull;

    public static ObjectCondition isNonNull = Objects::nonNull;

    public static DateCondition areOrdered = (before, after) -> before == null || after == null || before.compareTo(after) <= 0;

    public static DateCondition isAfter = (date, comp) -> date.compareTo(comp) > 0;

    public static DateCondition isAfterOrEqual = (date, comp) -> date.compareTo(comp) >= 0;

    public static DateCondition isBefore = (date, comp) -> date.compareTo(comp) < 0;

    public static DateCondition isBeforeOrEqual = (date, comp) -> date.compareTo(comp) <= 0;

    public static ObjectComparisonCondition isEqual = Object::equals;

    public static InCollectionCondition isIn = (o, collection) -> collection.contains(o);
}
