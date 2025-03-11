package com.fintech.weatherservice.dto;

import java.time.LocalDateTime;

public record WeatherResponse(
    LocalDateTime date,
    String temperature
) {
  public static WeatherResponse getEmptyWeather(){
    return new WeatherResponse(LocalDateTime.now(), "no data found");
  }
}
