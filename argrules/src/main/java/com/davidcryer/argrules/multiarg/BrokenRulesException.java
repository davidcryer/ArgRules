package com.davidcryer.argrules.multiarg;

public class BrokenRulesException extends RuntimeException {

    protected BrokenRulesException(final String[] messages) {
        super(concatenate(messages));
    }

    private static String concatenate(final String[] messages) {
        return concatenate(messages, new DefaultExceptionFormatter(StringUtils.NEW_LINE));
    }

    private static String concatenate(final String[] messages, final ExceptionFormatter formatter) {
        return formatter.toString(messages);
    }
}
