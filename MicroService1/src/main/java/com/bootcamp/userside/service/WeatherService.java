package com.bootcamp.userside.service;

import com.bootcamp.userside.model.Weather;
import com.bootcamp.userside.provider.Weatherprovider;
import com.bootcamp.userside.repository.RequestLogRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final Weatherprovider weatherProvider;
    private final RequestLogRepository requestLogRepository;

    public WeatherService(Weatherprovider weatherProvider, RequestLogRepository requestLogRepository) {
        this.weatherProvider = weatherProvider;
        this.requestLogRepository = requestLogRepository;
    }

    public Weather getWeather(String city) {
        return weatherProvider.getWeather(city);
    }
}
