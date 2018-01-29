package com.davidcryer.argrules.multiarg;

public class DelayedResult implements Result {
    private final Check check;
    private Boolean cachedCheck;
    private final String successNote;
    private final String errorNote;

    private DelayedResult(Check check, String errorNote, String successNote) {
        this.check = check;
        this.errorNote = errorNote;
        this.successNote = successNote;
    }

    public static DelayedResult delayed(final Check check, final String errorNote) {
        return delayed(check, errorNote, null);
    }

    public static DelayedResult delayed(final Check check, final String errorNote, final String successNote) {
        return new DelayedResult(check, successNote, errorNote);
    }

    @Override
    public boolean passed() {
        return checkDidPass();
    }

    @Override
    public String note() {
        return checkDidPass() ? successNote : errorNote;
    }

    private boolean checkDidPass() {
        if (cachedCheck == null) {
            cachedCheck = check.passes();
        }
        return cachedCheck;
    }

    public interface Check {
        boolean passes();
    }
}
