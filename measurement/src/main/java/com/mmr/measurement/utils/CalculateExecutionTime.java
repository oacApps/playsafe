package com.mmr.measurement.utils;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class CalculateExecutionTime {

    private Instant startTime;

    public void start(){
        startTime = Instant.now();
    }

    public long getDuration(){
        Instant endTime = Instant.now();
        return Duration.between(startTime, endTime).toMillis();
    }
}
