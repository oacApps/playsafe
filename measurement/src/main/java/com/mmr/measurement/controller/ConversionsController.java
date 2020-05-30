package com.mmr.measurement.controller;


import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.enums.MeasurementEnum;
import com.mmr.measurement.enums.UnitEnum;
import com.mmr.measurement.mapper.MapTo;
import com.mmr.measurement.service.MeasurementConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionsController {

    @Autowired
    MeasurementConversionService conversionService;

    @Autowired
    MapTo mapTo;

    @GetMapping("/ktoc/{unitValue}")
    public ResponseEntity<Double> kelvinToCelsius(@PathVariable double unitValue){
        ConversionDTO conversionDTO = mapTo.conversionDTO(MeasurementEnum.TEMPERATURE, UnitEnum.KELVIN, UnitEnum.CELSIUS, unitValue);
        double convertedValue = conversionService.convert(conversionDTO);
        return new ResponseEntity<>(convertedValue, HttpStatus.OK);
    }
}
