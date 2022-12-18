package com.example.springkafkaevents.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomEventListener {

    private final static String TOPIC_NAME = "my-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @EventListener
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
        kafkaTemplate.send(TOPIC_NAME, "TEST",event.getMessage());
    }
}
