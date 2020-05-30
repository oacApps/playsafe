package com.mmr.measurement.controller;


import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.enums.MeasurementEnum;
import com.mmr.measurement.enums.UnitEnum;
import com.mmr.measurement.mapper.MapTo;
import com.mmr.measurement.service.MeasurementConversionService;
import com.mmr.measurement.utils.CalculateExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER= LoggerFactory.getLogger(ConversionsController.class);

    @Autowired
    MeasurementConversionService conversionService;

    @Autowired
    CalculateExecutionTime calculateExecutionTime;

    @Autowired
    MapTo mapTo;

    @GetMapping("/ktoc/{unitValue}")
    public ResponseEntity<Double> kelvinToCelsius(@PathVariable double unitValue){
        calculateExecutionTime.start();
        ConversionDTO conversionDTO = mapTo.conversionDTO(MeasurementEnum.TEMPERATURE, UnitEnum.KELVIN, UnitEnum.CELSIUS, unitValue);
        double convertedValue = conversionService.convert(conversionDTO);
        LOGGER.info("Execution time for ktoc is : " + calculateExecutionTime.getDuration() + " milliseconds.");
        return new ResponseEntity<>(convertedValue, HttpStatus.OK);
    }

    @GetMapping("/ctok/{unitValue}")
    public ResponseEntity<Double> celsiusToKelvin(@PathVariable double unitValue){
        calculateExecutionTime.start();
        ConversionDTO conversionDTO = mapTo.conversionDTO(MeasurementEnum.TEMPERATURE, UnitEnum.CELSIUS, UnitEnum.KELVIN, unitValue);
        double convertedValue = conversionService.convert(conversionDTO);
        LOGGER.info("Execution time for ctok is : " + calculateExecutionTime.getDuration() + " milliseconds.");
        return new ResponseEntity<>(convertedValue, HttpStatus.OK);
    }

    @GetMapping("/mtok/{unitValue}")
    public ResponseEntity<Double> milesToKilometers(@PathVariable double unitValue){
        calculateExecutionTime.start();
        ConversionDTO conversionDTO = mapTo.conversionDTO(MeasurementEnum.LENGTH, UnitEnum.MILES, UnitEnum.KILOMETERS, unitValue);
        double convertedValue = conversionService.convert(conversionDTO);
        LOGGER.info("Execution time for mtok is : " + calculateExecutionTime.getDuration() + " milliseconds.");
        return new ResponseEntity<>(convertedValue, HttpStatus.OK);
    }

    @GetMapping("/ktom/{unitValue}")
    public ResponseEntity<Double> kilometersToMiles(@PathVariable double unitValue){
        calculateExecutionTime.start();
        ConversionDTO conversionDTO = mapTo.conversionDTO(MeasurementEnum.TEMPERATURE, UnitEnum.CELSIUS, UnitEnum.KELVIN, unitValue);
        double convertedValue = conversionService.convert(conversionDTO);
        LOGGER.info("Execution time for ktom is : " + calculateExecutionTime.getDuration() + " milliseconds.");
        return new ResponseEntity<>(convertedValue, HttpStatus.OK);
    }
}
