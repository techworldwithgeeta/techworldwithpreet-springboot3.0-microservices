package com.techworld.bookingservice.service;

import com.techworld.bookingservice.model.BookingRequest;
import com.techworld.bookingservice.model.BookingResponse;

public interface BookingService {

    public BookingResponse createBooking(BookingRequest bookingRequest);

}
