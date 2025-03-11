package com.fintech.weatherservice.model;

import java.time.LocalDateTime;

public record WeatherModel(
    LocalDateTime date,
    Double temperature,
    TemperatureType temperatureType
) {

}
