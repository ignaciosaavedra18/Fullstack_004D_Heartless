package com.duoc.heartless.controller;

import com.duoc.heartless.dto.WeatherDTO;
import com.duoc.heartless.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clima")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherDTO> clima(
            @RequestParam(defaultValue = "-33.45") double lat,
            @RequestParam(defaultValue = "-70.65") double lon) {

        WeatherDTO resultado = weatherService.obtenerClima(lat, lon);
        return ResponseEntity.ok(resultado);
    }
}


// Controlador que entrega información del clima usando una API externa. Recibe solicitudes para mostrar datos climáticos.