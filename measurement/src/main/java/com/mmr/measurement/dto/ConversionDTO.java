package com.mmr.measurement.dto;

import com.mmr.measurement.enums.MeasurementEnum;
import com.mmr.measurement.enums.UnitEnum;
import lombok.Data;

@Data
public class ConversionDTO {
    MeasurementEnum measurement;
    UnitEnum from;
    UnitEnum to;
    double value;
}
