package com.bootcamp.userside.model;

import com.bootcamp.userside.controller.response.WeatherResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Weather {
    @Id
    private String id;
    private float temperature;
    private LocalDateTime dateTime;
    private float humidity;
    private float wind_direction;
    private String city;

    @JsonIgnore
    public WeatherResponse createWeatherResponse() {
        return new WeatherResponse(
                this.temperature,
                this.dateTime,
                this.humidity,
                this.wind_direction,
                this.city
        );
    }
}
