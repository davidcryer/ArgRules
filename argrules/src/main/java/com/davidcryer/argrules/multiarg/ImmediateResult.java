package com.davidcryer.argrules.multiarg;

public class ImmediateResult implements Result {
    private final boolean passed;
    private final String note;

    private ImmediateResult(boolean passed, String note) {
        this.passed = passed;
        this.note = note;
    }

    public static ImmediateResult forSuccess(String note) {
        return new ImmediateResult(true, note);
    }

    public static ImmediateResult forFailure(String note) {
        return new ImmediateResult(false, note);
    }

    public static ImmediateResult forCheck(final boolean passed, final String noteIfFailed) {
        return forCheck(passed, noteIfFailed, null);
    }

    public static ImmediateResult forCheck(final boolean passed, final String noteIfFailed, final String noteIfPassed) {
        return passed ? forSuccess(noteIfPassed) : forFailure(noteIfFailed);
    }

    @Override
    public boolean passed() {
        return passed;
    }

    @Override
    public String note() {
        return note;
    }
}
