package com.techworld.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techworld.bookingservice.entity.FlightBooking;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

}
