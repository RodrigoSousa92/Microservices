package com.bootcamp.microservices2.model;

import com.bootcamp.microservices2.controller.response.WeatherResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Weather {
    @Id
    private String id;
    private float temperature;
    private LocalDateTime dateTime;
    private float humidity;
    private float wind_direction;

    @JsonIgnore
    public WeatherResponse createWeatherResponse() {
        return new WeatherResponse(
                this.temperature,
                this.dateTime,
                this.humidity,
                this.wind_direction
        );
    }
}