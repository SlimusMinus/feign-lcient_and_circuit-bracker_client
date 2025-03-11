package com.fintech.weatherservice.controller;

import com.fintech.weatherservice.dto.WeatherRequest;
import com.fintech.weatherservice.dto.WeatherResponse;
import com.fintech.weatherservice.facade.WeatherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
@RequiredArgsConstructor
public class WeatherController {

  private final WeatherFacade weatherFacade;

  @PostMapping
  public WeatherResponse getWeather(@RequestBody WeatherRequest weatherResponse) {
    return weatherFacade.getWeather(weatherResponse);
  }

}
