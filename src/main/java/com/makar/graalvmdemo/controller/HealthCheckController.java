package com.makar.graalvmdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class HealthCheckController {

    @GetMapping
    public String health() {
        return "OK";
    }

}
