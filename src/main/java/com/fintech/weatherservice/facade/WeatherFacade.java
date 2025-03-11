package com.fintech.weatherservice.facade;

import com.fintech.weatherservice.client.ExternalWeatherApi;
import com.fintech.weatherservice.client.model.WeatherApiResponse;
import com.fintech.weatherservice.dto.WeatherRequest;
import com.fintech.weatherservice.dto.WeatherResponse;
import com.fintech.weatherservice.model.WeatherModel;
import com.fintech.weatherservice.service.WeatherService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherFacade {

  private final WeatherService weatherService;
  private final ExternalWeatherApi externalWeatherApi;

  public WeatherResponse getWeather(WeatherRequest request) {

    Optional<WeatherModel> weatherModelOpt = weatherService.getWeather(request.longitude(), request.latitude(), request.date());

    if (weatherModelOpt.isPresent()) {
      WeatherModel weatherModel = weatherModelOpt.get();
      return new WeatherResponse(weatherModel.date(), weatherModel.temperature() + weatherModel.temperatureType().name());
    } else {
      return getExternalWeatherApi(request);
    }
  }

  private WeatherResponse getExternalWeatherApi(WeatherRequest request) {
    System.out.println(request);
    WeatherApiResponse weather = externalWeatherApi.getWeather(request.longitude(),  request.latitude());

    if (weather != null) {
      return new WeatherResponse(weather.date(), weather.temperature());
    } else {
      return WeatherResponse.getEmptyWeather();
    }
  }

  private WeatherResponse fallbackWeather(WeatherRequest request, Throwable throwable) {
    System.out.println("Fallback triggered: " + throwable.getMessage());
    return WeatherResponse.getEmptyWeather();
  }
}
