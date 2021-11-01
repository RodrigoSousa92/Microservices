package com.bootcamp.microservices2.provider;

import com.bootcamp.microservices2.controller.response.WeatherResponseAPI;
import com.bootcamp.microservices2.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class WeatherProvider {
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public WeatherProvider(RestTemplate restTemplate, @Value("${weather.api.url}") String apiUrl, @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public Weather getWeatherForCity(String city) {
        String url = apiUrl + "?key=" + apiKey + "&q=" + city + "&aqi=no";
        final ResponseEntity<WeatherResponseAPI> response = restTemplate.getForEntity(url, WeatherResponseAPI.class);
        return Weather
                .builder()
                .temperature(response.getBody().getCurrent().getTempC())
                .dateTime(LocalDateTime.parse(response.getBody().getCurrent().getLastUpdated()))
                .humidity(response.getBody().getCurrent().getHumidity())
                .wind_direction(response.getBody().getCurrent().getWind_dir())
                .build();
    }
}
