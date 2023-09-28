package com.techworld.bookingservice.model;

import lombok.Data;

@Data
public final class FlightBookingRequest extends BookingRequest {
    private String flightNumber;

}
