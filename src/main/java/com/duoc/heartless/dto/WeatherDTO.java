package com.duoc.heartless.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentWeather {
        private Double temperature;
        private Double windspeed;
    }
}

// DTO utilizado para transportar la información del clima. Un DTO sirve para mover datos entre capas sin exponer directamente la entidad.