package com.techworld.bookingservice.model;

import lombok.Data;

@Data
public sealed class BookingRequest permits FlightBookingRequest, HotelBookingRequest {

    String passengerName;
    double amount;
    PaymentMode paymentMode;
    private String flightNumber;
    private int seats;
}
