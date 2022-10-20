package com.raiseup.exploreApi.model;

public enum Regional {
    NORTHERN_CALIFORNIA("Northern California"),
    CENTRAL_COAST("Central California"),
    SOUTHERN_CALIFORNIA("Southern California"),
    VARIES("Varies");
    private String label;

    Regional(String label) {
        this.label = label;
    }

    public static Regional findByLabel(String byLabel) {
        for (Regional r : Regional.values()) {
            if (r.label.equalsIgnoreCase(byLabel)) return r;
        }
        return null;
    }
}
