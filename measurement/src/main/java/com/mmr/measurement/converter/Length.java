package com.mmr.measurement.converter;

import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.enums.UnitEnum;
import com.mmr.measurement.intf.Converter;

public class Length implements Converter {

    static double MILES_VALUE = 1609.35;
    static double KILOMETERS_VALUE = 1000;

    @Override
    public double convert(ConversionDTO conversionDTO) {
        return fromUnit(conversionDTO.getTo(), toUnit(conversionDTO.getFrom(), conversionDTO.getValue()));
    }

    /*Convert to meter*/
    @Override
    public double toUnit(UnitEnum from, double value) {
        double meters;
        switch (from){
            case MILES: meters = ( value * MILES_VALUE ); break;
            case KILOMETERS: meters = ( value * KILOMETERS_VALUE ); break;
            default: meters = value; break;
        }
        return meters;
    }

    /*convert from meter to target unit*/
    @Override
    public double fromUnit(UnitEnum to, double value) {
        double result;

        switch (to){
            case MILES: result = ( value / MILES_VALUE ); break;
            case KILOMETERS: result = ( value / KILOMETERS_VALUE ); break;
            default: result = value; break;
        }
        return result;
    }
}
