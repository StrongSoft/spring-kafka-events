package com.example.springkafkaevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringKafkaEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaEventsApplication.class, args);
    }

}
