package com.example.springdrools.model;

/**
 * @author z.Taghizadeh
 */
public enum TypeEnum {

    DIAMOND("diamond"),
    GOLD("gold");


    private final String type;

    private TypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
