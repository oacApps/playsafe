package com.mmr.measurement.converter;

import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.enums.UnitEnum;
import com.mmr.measurement.intf.Converter;

public class Temperature implements Converter {
    @Override
    public double convert(ConversionDTO conversionDTO) {
        return fromUnit(conversionDTO.getTo(), toUnit(conversionDTO.getFrom(), conversionDTO.getValue()));
    }

    /*Convert to fahrenheit*/
    @Override
    public double toUnit(UnitEnum from, double value) {
        double fahrenheit;
        switch (from){
            case CELSIUS: fahrenheit = ((value * 9/5) + 32); break;
            case KELVIN: fahrenheit = (((value - 273.15) * 9/5)+ 32); break;
            default: fahrenheit = value; break;
        }
        return fahrenheit;
    }


    /*convert from fahrenheit to target unit*/
    @Override
    public double fromUnit(UnitEnum to, double value) {
        double result;

        switch (to){
            case CELSIUS: result = (( value - 32) * 5/9); break;
            case KELVIN: result = ((( value - 32) * 5/9) + 273.15); break;
            default: result = value; break;
        }
        return result;
    }
}
