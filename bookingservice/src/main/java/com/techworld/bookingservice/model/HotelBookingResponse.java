package com.techworld.bookingservice.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public final class HotelBookingResponse extends BookingResponse {

    private String hotelName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
