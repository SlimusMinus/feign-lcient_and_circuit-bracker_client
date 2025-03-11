package com.fintech.weatherservice.dto;

import java.time.LocalDateTime;

public record WeatherRequest(
    Double longitude,
    Double latitude,
    LocalDateTime date
) {

}
