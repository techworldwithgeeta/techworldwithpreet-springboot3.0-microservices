package com.techworld.flightsearchservice.service;

import java.util.List;

import com.techworld.flightsearchservice.model.FlightSearchRequest;
import com.techworld.flightsearchservice.model.FlightSearchResponse;

public interface FlightSearchService {

    public List<FlightSearchResponse> searchFlights(FlightSearchRequest flightSearchRequest);
}