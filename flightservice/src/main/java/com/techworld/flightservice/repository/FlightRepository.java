package com.techworld.flightservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techworld.flightservice.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);
}
