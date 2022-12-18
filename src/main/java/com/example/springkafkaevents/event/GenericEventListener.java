package com.example.springkafkaevents.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GenericEventListener {
    @EventListener(condition = "#event.success")
    public void handleEvent(GenericEvent event){
        System.out.println("Received spring custom event by annotation listener - 1" + event.getResult());
    }
}
