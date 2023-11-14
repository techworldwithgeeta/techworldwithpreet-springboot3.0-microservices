package com.techworld.paymentservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techworld.paymentservice.entity.Payment;
import com.techworld.paymentservice.model.PaymentMode;
import com.techworld.paymentservice.model.PaymentRequest;
import com.techworld.paymentservice.model.PaymentResponse;
import com.techworld.paymentservice.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public long processPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        Payment payment = Payment.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .bookingId(paymentRequest.getBookingId())
                .amount(paymentRequest.getAmount())
                .build();

        paymentRepository.save(payment);

        log.info("Payment Completed with Id: {}", payment.getPaymentId());

        return payment.getPaymentId();

    }

    @Override
    public PaymentResponse getPaymentDetailsByBookingId(Long bookingId) {
        log.info("Getting payment details for the Booking Id: {}", bookingId);

        Payment payment = paymentRepository.findByBookingId(bookingId);

        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(payment.getPaymentId())
                .paymentMode(PaymentMode.valueOf(payment.getPaymentMode()))
                .paymentDate(payment.getPaymentDate())
                .bookingId(payment.getBookingId())
                .status(payment.getPaymentStatus())
                .amount(payment.getAmount())
                .build();

        return paymentResponse;
    }

}
