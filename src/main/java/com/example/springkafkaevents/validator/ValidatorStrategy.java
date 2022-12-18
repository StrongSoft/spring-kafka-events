package com.example.springkafkaevents.validator;

public interface ValidatorStrategy {
    String getKey();

    boolean getFlag();
}
