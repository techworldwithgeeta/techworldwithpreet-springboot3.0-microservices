package com.techworld.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techworld.bookingservice.entity.HotelBooking;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {

}
