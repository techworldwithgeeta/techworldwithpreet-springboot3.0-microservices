package com.techworld.flightsearchservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techworld.flightsearchservice.entity.Flight;

public interface FlightSearchRepository extends MongoRepository<Flight, Long> {

    List<Flight> findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual(
            String origin,
            String destination, LocalDate date, int passengers);
}
