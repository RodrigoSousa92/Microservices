package com.bootcamp.microservices2.controller;

import com.bootcamp.microservices2.controller.response.WeatherResponse;
import com.bootcamp.microservices2.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
        private final WeatherService weatherService;

        public WeatherController(WeatherService weatherService) {
            this.weatherService = weatherService;
        }

        @GetMapping("/weather")
        public WeatherResponse getWeatherByLocation(@RequestParam String city) {
            return weatherService.getWeather(city).createWeatherResponse();
        }
    }