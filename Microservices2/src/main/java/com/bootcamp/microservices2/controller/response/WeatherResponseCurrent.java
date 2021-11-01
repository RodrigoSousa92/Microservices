package com.bootcamp.microservices2.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseCurrent {

    @JsonProperty(value = "temp_c")
    public float tempC;
    @JsonProperty(value = "last_updated")
    public String lastUpdated;
    @JsonProperty(value = "humidity")
    public float humidity;
    @JsonProperty(value = "wind_dir")
    public float wind_dir;

}
