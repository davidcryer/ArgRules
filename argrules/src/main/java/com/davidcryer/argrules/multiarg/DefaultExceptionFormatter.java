package com.davidcryer.argrules.multiarg;

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
        boolean hasAddedMessage = false;
        for (final String message : messages) {
            if (message != null) {
                if (hasAddedMessage) {
                    builder.append(delimiter);
                }
                builder.append(message);
                hasAddedMessage = true;
            }
        }
        return builder.toString();
    }
}
