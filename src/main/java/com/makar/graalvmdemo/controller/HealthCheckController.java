package com.makar.graalvmdemo.controller;

import com.makar.graalvmdemo.model.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<HealthResponse> health() {
        final HealthResponse healthResponse = new HealthResponse();
        healthResponse.setStatus("UP");
        return ResponseEntity.ok(healthResponse);
    }

}
