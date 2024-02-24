package com.techworld.bookingservice.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.techworld.bookingservice.entity.Booking;

import com.techworld.bookingservice.external.client.FlightService;
import com.techworld.bookingservice.model.BookingRequest;
import com.techworld.bookingservice.model.BookingResponse;
import com.techworld.bookingservice.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@Primary
public class BookingServiceImpl implements BookingService {

        @Autowired
        private BookingRepository bookingRepository;

        @Autowired
        private FlightService flightService;

        @Override
        public String reserveSeats(BookingRequest bookingRequest) {
                log.info("create Booking for user {}", bookingRequest.getPassengerName());

                // set the flight booking status as created
                Booking booking = Booking
                                .builder()
                                .passengerName(bookingRequest.getPassengerName())
                                .flightNumber(bookingRequest.getFlightNumber())
                                .seats(bookingRequest.getSeats())
                                .bookingNumber(UUID.randomUUID().toString())
                                .amount(bookingRequest.getAmount())
                                .paymentMode(bookingRequest.getPaymentMode().name())
                                .status("BOOKING_CREATED")
                                .build();

                bookingRepository.save(booking);

                log.info("booking status is {} ", booking.getStatus());

                flightService.reserveSeats(bookingRequest.getFlightNumber(),
                                bookingRequest.getSeats());
                log.info("Seats are reserverd for booking {}", bookingRequest.getFlightNumber());

                return "Booking Id created Succesfully";
        }

        @Override
        public BookingResponse createBooking(BookingRequest bookingRequest) {
                throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
        }
}