package com.techworld.bookingservice.service;

//import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;

//import com.techworld.bookingservice.external.client.FlightService;
//import com.techworld.bookingservice.model.BookingRequest;
//import com.techworld.bookingservice.repository.BookingRepository;

import jakarta.transaction.Transactional;
//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Service
@Transactional
public class BookingServiceImpl {

        // @Autowired
        // private BookingRepository bookingRepository;

        // @Autowired
        // private FlightService flightService;

        // @Autowired
        // private WebClient.Builder webClientBuilder;

        /*
         * public String createBooking(BookingRequest bookingRequest) {
         * log.info("create Booking for user {}", bookingRequest.getUserId());
         * 
         * // set the flight booking status as created
         * Booking booking = Booking
         * .builder()
         * .userId(bookingRequest.getUserId())
         * .flightNumber(bookingRequest.getFlightNumber())
         * .seats(bookingRequest.getSeats())
         * .bookingNumber(UUID.randomUUID().toString())
         * .amount(bookingRequest.getAmount())
         * .paymentMode(bookingRequest.getPaymentMode())
         * .status("BOOKING_CREATED")
         * .build();
         * 
         * bookingRepository.save(booking);
         * 
         * log.info("booking status is {} ", booking.getStatus());
         * 
         * // check for seat availability and reduce the seats for flight
         * flightService.reserveSeats(bookingRequest.getFlightNumber(),
         * bookingRequest.getSeats());
         * log.info("Seats are reserverd for booking {}",
         * bookingRequest.getFlightNumber());
         * 
         * return "Booking Id created Succesfully";
         * }
         */

}
