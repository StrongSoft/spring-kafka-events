package com.example.springkafkaevents.service;

import com.example.springkafkaevents.entity.User;
import com.example.springkafkaevents.event.CustomEventPublisher;
import com.example.springkafkaevents.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DomainService {

    private final UserRepository userRepository;
    private final CustomEventPublisher customEventPublisher;

    @Transactional
    public void addAge(String userId) {
        userRepository.findByUserId(userId)
            .ifPresent(entity -> {
                entity.addAge();
                userRepository.save(entity);
            });
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
