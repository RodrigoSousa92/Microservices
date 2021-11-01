package com.bootcamp.userside.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private float temp;
    private LocalDateTime dateTime;
    private float humidity;
    private float wind_direction;
    private String city;
}
