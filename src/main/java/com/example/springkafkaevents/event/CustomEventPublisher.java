package com.example.springkafkaevents.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(final String message) {
        System.out.println("Publishing custom event message = " + message);
        CustomEvent customSpringEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}
