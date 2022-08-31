package com.roovalant.gapgrap.domain.enumeration;

/**
 * The ResourceType.
 */
public enum ResourceType {

    Apartment("아파트"),
    Officetel("오피스"),
    ;

    private String text;

    ResourceType(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
