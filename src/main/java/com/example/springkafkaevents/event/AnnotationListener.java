package com.example.springkafkaevents.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//@Component
public class AnnotationListener {

    //@EventListener
    //@Async
    public void handleEvent(CustomEvent customEvent) {
        try {
            //Thread.sleep(3000);
            System.out.println(
                "Received spring custom event by annotation listener - "
                    + customEvent.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
