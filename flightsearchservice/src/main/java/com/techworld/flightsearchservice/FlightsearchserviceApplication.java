package com.techworld.flightsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightsearchserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsearchserviceApplication.class, args);
	}

}
