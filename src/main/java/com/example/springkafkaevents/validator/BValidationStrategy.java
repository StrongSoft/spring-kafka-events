package com.example.springkafkaevents.validator;

import org.springframework.stereotype.Component;

@Component
public class BValidationStrategy implements ValidatorStrategy{

    @Override
    public String getKey() {
        return "B";
    }

    @Override
    public boolean getFlag() {
        return true;
    }
}
