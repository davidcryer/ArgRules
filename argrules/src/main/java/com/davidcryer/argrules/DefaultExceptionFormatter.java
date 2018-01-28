package com.davidcryer.argrules;

public class DefaultExceptionFormatter implements ExceptionFormatter {
    private final String delimiter;

    protected DefaultExceptionFormatter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String toString(final String[] messages) {
        if (messages.length == 0) {
            return "";
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < messages.length; i++) {
            if (i > 0) {
                builder.append(delimiter);
            }
            builder.append(messages[i]);
        }
        return builder.toString();
    }
}
