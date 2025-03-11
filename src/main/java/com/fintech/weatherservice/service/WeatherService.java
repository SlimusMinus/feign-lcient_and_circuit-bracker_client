package com.fintech.weatherservice.service;

import com.fintech.weatherservice.model.WeatherModel;
import com.fintech.weatherservice.repo.WeatherRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class WeatherService {

  private final WeatherRepository repository;

  public Optional<WeatherModel> getWeather(Double longitude, Double latitude, LocalDateTime date) {
    Assert.notNull(longitude, "longitude is empty");
    Assert.notNull(latitude, "latitude is empty");
    return repository.getWeather(longitude, latitude, date == null ? LocalDateTime.now() : date);
  }
}
