package com.techworld.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.techworld.notificationservice.event.BookingCompletedEvent;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceApplication {

	private final ObservationRegistry observationRegistry;
	private final Tracer tracer;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(BookingCompletedEvent bookingCompletedEvent) {
		Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
			log.info("Got message <{}>", bookingCompletedEvent);

			log.info("TraceId- {}, Received Notification for Booking - {}",
					this.tracer.currentSpan().context().traceId(),
					bookingCompletedEvent.getBookingNumber());
			// send out an email notification
		});
	}
}
