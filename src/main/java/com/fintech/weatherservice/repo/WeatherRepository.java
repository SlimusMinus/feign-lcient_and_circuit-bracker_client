package com.fintech.weatherservice.repo;

import com.fintech.weatherservice.model.TemperatureType;
import com.fintech.weatherservice.model.WeatherModel;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {

  private final Random random = new Random();

  public Optional<WeatherModel> getWeather(Double longitude, Double latitude, LocalDateTime date){
    if(longitude > 20 && latitude > 20){
      return Optional.of(new WeatherModel(date.truncatedTo(ChronoUnit.HOURS), random.nextDouble(40d), TemperatureType.C));
    } else {
      return Optional.empty();
    }
  }
}
