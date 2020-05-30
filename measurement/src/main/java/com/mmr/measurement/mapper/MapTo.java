package com.mmr.measurement.mapper;

import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.enums.MeasurementEnum;
import com.mmr.measurement.enums.UnitEnum;
import org.springframework.stereotype.Component;

@Component
public class MapTo {

    public ConversionDTO conversionDTO(MeasurementEnum measurementEnum, UnitEnum from, UnitEnum to, double value){
        ConversionDTO conversionDTO = new ConversionDTO();
        conversionDTO.setMeasurement(measurementEnum);
        conversionDTO.setFrom(from);
        conversionDTO.setTo(to);
        conversionDTO.setValue(value);
        return conversionDTO;
    }
}
