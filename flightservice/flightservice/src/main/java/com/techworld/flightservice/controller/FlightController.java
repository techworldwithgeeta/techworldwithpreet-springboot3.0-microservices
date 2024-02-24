package com.techworld.flightservice.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techworld.flightservice.model.FlightRequest;
import com.techworld.flightservice.model.FlightResponse;
import com.techworld.flightservice.service.FlightService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/v1/api/flights")
@RequiredArgsConstructor
@Log4j2
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightRequest flightRequest) {

        log.info("createFlight");
        var flight = flightService.createFlight(flightRequest);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        log.debug("getAllFlights");
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public FlightResponse getFlightByNumber(@PathVariable("id") String flightNumber) {
        log.info("getFlightByNumber");
        return flightService.getFlightByNumber(flightNumber);
    }

    @PutMapping("/reserveSeats/{id}")
    public void reserveSeats(@PathVariable("id") String flightNumber,
            @RequestParam int seats) {

        flightService.reserveSeats(flightNumber, seats);
    }

}
