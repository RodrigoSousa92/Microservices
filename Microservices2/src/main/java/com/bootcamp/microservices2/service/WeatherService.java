package com.bootcamp.microservices2.service;

import com.bootcamp.microservices2.model.Weather;
import com.bootcamp.microservices2.provider.WeatherProvider;
import com.bootcamp.microservices2.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherProvider weatherProvider;

    public WeatherService(WeatherRepository weatherRepository, WeatherProvider weatherProvider) {
        this.weatherRepository = weatherRepository;
        this.weatherProvider = weatherProvider;
    }

    public Weather getWeather(String city) {
        Optional<Weather> weatherOptional = weatherRepository.findByCity(city);
        if (weatherOptional.isPresent()) {
            Weather weather = weatherOptional.get();

            LocalDateTime timeThreshold = weather.getDateTime().minusHours(1);
            if (weather.getDateTime().isAfter(timeThreshold)) {
                return weather;
            }
        }

        Weather newWeather = weatherProvider.getWeatherForCity(city);
        weatherRepository.save(newWeather);
        return newWeather;
    }
}
