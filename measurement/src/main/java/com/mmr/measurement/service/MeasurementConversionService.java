package com.mmr.measurement.service;

import com.mmr.measurement.converter.Length;
import com.mmr.measurement.converter.Temperature;
import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.intf.Converter;
import org.springframework.stereotype.Service;

@Service
public class MeasurementConversionService {

    public double convert(ConversionDTO conversionDTO){
        double result = 0;

        Converter converter;

        switch (conversionDTO.getMeasurement()){
            case LENGTH:
                converter = new Length();
                result = converter.convert(conversionDTO);
                break;
            case TEMPERATURE :
                converter = new Temperature();
                result = converter.convert(conversionDTO);
                break;
            default:
                break;
        }

        return result;
    }
}
