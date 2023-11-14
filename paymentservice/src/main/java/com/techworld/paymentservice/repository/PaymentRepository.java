package com.techworld.paymentservice.repository;

import org.springframework.stereotype.Repository;
import com.techworld.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByBookingId(Long bookingId);

}
