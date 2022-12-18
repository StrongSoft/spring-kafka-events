package com.example.springkafkaevents.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GenericEventPublisher<T> {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(final T message, final boolean success) {
        GenericEvent<T> genericEvent = new GenericEvent<>(message, success);
        applicationEventPublisher.publishEvent(genericEvent);
    }
}
