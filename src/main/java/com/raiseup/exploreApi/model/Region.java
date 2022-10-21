package com.raiseup.exploreApi.model;

public enum Region {
    NORTHERN_CALIFORNIA("Northern California"),
    CENTRAL_COAST("Central California"),
    SOUTHERN_CALIFORNIA("Southern California"),
    VARIES("Varies");
    private String label;

    Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String byLabel) {
        for (Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel)) return r;
        }
        return null;
    }
}
