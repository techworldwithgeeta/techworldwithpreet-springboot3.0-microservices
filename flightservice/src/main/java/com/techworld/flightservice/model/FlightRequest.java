package com.techworld.flightservice.model;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record FlightRequest(
                String flightNumber,
                String origin,
                String destination,
                LocalDate departureDate,
                LocalDate arrivalDate,
                int totalSeats,
                int availableSeats,
                double amount) {

}
