package com.techworld.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @PostMapping("/bookingServiceFallBack")
    public String bookingServiceFallBack() {
        return "Booking Service is down!";
    }

    @GetMapping("/flightSearchServiceFallBack")
    public String flightSearchServiceFallBack() {
        return "Flight Search Service is down!";
    }

}
