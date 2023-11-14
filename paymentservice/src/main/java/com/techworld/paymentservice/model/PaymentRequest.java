
package com.techworld.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {

    private long bookingId;
    private long amount;
    private String transactionNumber;
    private PaymentMode paymentMode;

}
