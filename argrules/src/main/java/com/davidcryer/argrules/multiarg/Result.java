package com.davidcryer.argrules.multiarg;

public class Result {
    private final boolean passed;
    private final String note;

    private Result(boolean passed, String note) {
        this.passed = passed;
        this.note = note;
    }

    public static Result forSuccess(String note) {
        return new Result(true, note);
    }

    public static Result forFailure(String note) {
        return new Result(false, note);
    }

    public static Result forCheck(final boolean passed, final String noteIfFailed) {
        return forCheck(passed, null, noteIfFailed);
    }

    public static Result forCheck(final boolean passed, final String noteIfPassed, final String noteIfFailed) {
        return passed ? forSuccess(noteIfPassed) : forFailure(noteIfFailed);
    }

    public boolean passed() {
        return passed;
    }

    public String note() {
        return note;
    }
}
