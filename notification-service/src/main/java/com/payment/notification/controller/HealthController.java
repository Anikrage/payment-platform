package com.payment.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    
    @GetMapping("/health")
    public String health() {
        return "Notification Service is UP";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Notification Service";
    }
}
