package com.fintech.weatherservice.client.model;

import java.time.LocalDateTime;

public record WeatherApiResponse(
    LocalDateTime date,
    String temperature
) {

}
