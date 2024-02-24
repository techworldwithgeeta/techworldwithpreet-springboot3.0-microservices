package com.techworld.bookingservice.external.decoder;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techworld.bookingservice.exception.BookingException;
import com.techworld.bookingservice.external.response.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;

@Slf4j
public class CustomErrorDecoder implements
        ErrorDecoder {

    @Override
    public Exception decode(String arg0, Response response) {

        log.info("::{}", response.request().url());
        log.info("::{}", response.request().headers());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(),
                    ErrorResponse.class);

            return new BookingException(errorResponse.getErrorMessage(),
                    errorResponse.getErrorCode(),
                    response.status());

        } catch (IOException e) {
            throw new BookingException("Internal Server Error",
                    "INTERNAL_SERVER_ERROR",
                    500);
        }
    }

}
