package com.davidcryer.argrules.multiarg;

public class BrokenRulesException extends RuntimeException {

    protected BrokenRulesException(final Results results) {
        super(concatenate(results.toMessages()));
    }

    private static String concatenate(final String[] messages) {
        return concatenate(messages, new DefaultExceptionFormatter(StringUtils.NEW_LINE));
    }

    private static String concatenate(final String[] messages, final ExceptionFormatter formatter) {
        return formatter.toString(messages);
    }
}
