package com.techworld.bookingservice.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public final class HotelBookingRequest extends BookingRequest {

    private String hotelName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
