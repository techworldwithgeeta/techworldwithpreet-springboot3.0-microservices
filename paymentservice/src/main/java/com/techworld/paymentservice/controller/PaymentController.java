
package com.techworld.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techworld.paymentservice.model.PaymentRequest;
import com.techworld.paymentservice.model.PaymentResponse;
import com.techworld.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/v1/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Long processPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.processPayment(paymentRequest);
    }

    @GetMapping()
    public ResponseEntity<PaymentResponse> getPaymentDetailsByBookingNumber(
            @RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByBookingId(id),
                HttpStatus.OK);
    }
}
