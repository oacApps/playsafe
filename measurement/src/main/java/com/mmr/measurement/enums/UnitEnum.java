package com.mmr.measurement.enums;

public enum UnitEnum {
    MILES("Miles"),
    KILOMETERS("Kilometers"),
    KELVIN("Kelvin"),
    CELSIUS("Celsius");

    private final String name;

    UnitEnum(String name) {
        this.name = name;
    }
}
