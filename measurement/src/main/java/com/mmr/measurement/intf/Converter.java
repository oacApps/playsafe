package com.mmr.measurement.intf;

import com.mmr.measurement.dto.ConversionDTO;
import com.mmr.measurement.enums.UnitEnum;

public interface Converter {
    double convert(ConversionDTO conversionDTO);
    double toUnit(UnitEnum from, double value);
    double fromUnit(UnitEnum to, double value);
}
