
package com.techworld.bookingservice.model;

import java.time.LocalDate;

import lombok.Data;

@Data

public sealed class BookingResponse permits FlightBookingResponse, HotelBookingResponse {

    private Long id;

    private String bookingNumber;
    private String passengerName;
    private String status;
    private double amount;
    private String paymentMode;
    private LocalDate bookingDate;
}
