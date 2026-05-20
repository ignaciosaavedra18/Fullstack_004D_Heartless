package com.duoc.heartless.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${openmeteo.base-url}")
    private String openMeteoBaseUrl;

    @Bean
    public WebClient weatherWebClient() {
        return WebClient.builder()
                .baseUrl(openMeteoBaseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}

//Configura WebClient para poder consumir APIs externas,  Sirve para crear el cliente que usa la aplicación para conectarse a servicios externos, como la API del clima.