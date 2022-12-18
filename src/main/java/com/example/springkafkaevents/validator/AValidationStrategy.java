package com.example.springkafkaevents.validator;

import org.springframework.stereotype.Component;

@Component
public class AValidationStrategy implements ValidatorStrategy{

    @Override
    public String getKey() {
        return "A";
    }

    @Override
    public boolean getFlag() {
        return false;
    }
}
