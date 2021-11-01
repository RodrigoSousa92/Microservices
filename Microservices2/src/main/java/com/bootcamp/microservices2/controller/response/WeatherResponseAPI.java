package com.bootcamp.microservices2.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseAPI {
    @JsonProperty(value = "current")
    private WeatherResponseCurrent current;
}
