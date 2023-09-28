package com.techworld.flightservice.service;

import java.util.List;

import com.techworld.flightservice.model.FlightRequest;
import com.techworld.flightservice.model.FlightResponse;

public interface FlightService {

    FlightResponse createFlight(FlightRequest flightRequest);

    List<FlightResponse> getAllFlights();

    FlightResponse getFlightByNumber(String flightNumber);

}
