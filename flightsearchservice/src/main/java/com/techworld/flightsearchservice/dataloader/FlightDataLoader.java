package com.techworld.flightsearchservice.dataloader;

import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.techworld.flightsearchservice.entity.Flight;
import com.techworld.flightsearchservice.repository.FlightSearchRepository;

@Component
public class FlightDataLoader implements CommandLineRunner {
    private final FlightSearchRepository flightSearchRepository;

    public FlightDataLoader(FlightSearchRepository flightSearchRepository) {
        this.flightSearchRepository = flightSearchRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Remove existing flights (optional)
        flightSearchRepository.deleteAll();

        // Create sample flights
        Flight flight1 = new Flight(1l, "EK203", "DXB", "SWZ",
                LocalDate.parse("2023-06-23"), LocalDate.parse("2023-06-23"), 15000.00, 250, 130);
        Flight flight2 = new Flight(2l, "EK204", "DXB", "SWZ",
                LocalDate.parse("2023-06-22"), LocalDate.parse("2023-06-24"), 18000.00, 250, 200);
        Flight flight3 = new Flight(3l, "EK205", "IND", "DXB",
                LocalDate.parse("2023-06-25"), LocalDate.parse("2023-06-27"), 10000.00, 250, 150);

        // Save flights to the database
        flightSearchRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

    }
}
