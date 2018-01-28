package com.davidcryer.argrules;

public abstract class Results<E extends Results.Exception> {

    void checkPassed(final CheckFailedCallback<E> failCallback) {
        if (passed()) {
            failCallback.checkFailed(exception());
        }
    }

    protected abstract boolean passed();

    protected abstract E exception();

    protected abstract String[] toMessages();

    public static abstract class Exception extends RuntimeException {

        protected Exception(final String[] messages) {
            super(concatenate(messages));
        }

        private static String concatenate(final String[] messages) {
            return concatenate(messages, new DefaultExceptionFormatter(StringUtils.NEW_LINE));
        }

        private static String concatenate(final String[] messages, final ExceptionFormatter formatter) {
            return formatter.toString(messages);
        }
    }
}
