package com.raiseup.exploreApi.model;

public enum Difficulty {
    EASY("Easy"),
    MEDIUM("Medium"),
    DIFFICULT("Difficult"),
    VARIES("Varies");

    private String label;
    Difficulty(String label) {
        this.label=label;
    }
    public static Difficulty findByLabel(String byLabel) {
        for (Difficulty r : Difficulty.values()) {
            if (r.label.equalsIgnoreCase(byLabel)) return r;
        }
        return null;
    }
}
