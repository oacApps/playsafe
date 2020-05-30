package com.mmr.measurement.enums;

public enum MeasurementEnum {

    LENGTH("Length"),
    TEMPERATURE("Temperature");

    private final String name;

    MeasurementEnum(String name) {
        this.name = name;
    }
}
