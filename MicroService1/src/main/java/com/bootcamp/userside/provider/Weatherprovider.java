package com.bootcamp.userside.provider;

import com.bootcamp.userside.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Weatherprovider {
    private final RestTemplate restTemplate;
    private final String baseurl;

    public Weatherprovider(RestTemplate restTemplate, @Value("${weather.provider.url}") String url) {
        this.restTemplate = restTemplate;
        this.baseurl = url;
    }

    public Weather getWeather(String city) {
        String url = baseurl + "weather&q=" + city;
        final ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class);
        return new Weather(
                response.getBody().getId(),
                response.getBody().getTemperature(),
                response.getBody().getDateTime(),
                response.getBody().getHumidity(),
                response.getBody().getWind_direction(),
                response.getBody().getCity());
    }
}