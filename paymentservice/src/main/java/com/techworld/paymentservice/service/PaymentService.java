package com.techworld.paymentservice.service;

import com.techworld.paymentservice.model.PaymentRequest;
import com.techworld.paymentservice.model.PaymentResponse;

public interface PaymentService {

    long processPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByBookingId(Long bookingId);

}
