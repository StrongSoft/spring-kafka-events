package com.example.springkafkaevents.validator;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationFactory {

    private final Map<String, ValidatorStrategy> factory;

    @Autowired
    public ValidationFactory(Set<ValidatorStrategy> sets) {
        this.factory = new HashMap<>();
        sets.forEach(set -> factory.put(set.getKey(), set));
    }

    public ValidatorStrategy find(String key) {
        System.out.println("factory = " + factory);
        return factory.get(key);
    }
}
