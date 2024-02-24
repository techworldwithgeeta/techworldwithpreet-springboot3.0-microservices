package com.techworld.bookingservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingException extends RuntimeException {

    private String errorCode;
    private int status;

    public BookingException(String message, String errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

}
