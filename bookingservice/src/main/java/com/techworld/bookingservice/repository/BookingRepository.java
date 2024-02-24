package com.techworld.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techworld.bookingservice.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
