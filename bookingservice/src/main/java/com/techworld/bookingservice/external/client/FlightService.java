package com.techworld.bookingservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techworld.bookingservice.exception.BookingException;

//@CircuitBreaker(name = "external", fallbackMethod = "fallback")
//@FeignClient(name = "flight-service/v1/api/flights")
// , url = "http://flight-service/v1/api/flights")

@FeignClient(name = "flight-service", url = "http://localhost:8082/v1/api/flights")

public interface FlightService {

    @PutMapping("/reserveSeats/{id}")
    public void reserveSeats(@PathVariable("id") String flightNumber,
            @RequestParam int seats);

    default void fallback(Exception e) {
        throw new BookingException("Flight Service is not available",
                "UNAVAILABLE",
                500);
    }
}
