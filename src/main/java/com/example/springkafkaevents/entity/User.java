package com.example.springkafkaevents.entity;

import com.example.springkafkaevents.event.CustomEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

@Getter
@Builder
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User extends AbstractAggregateRoot<User> {

    public User() {
    }

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userNo;
    private String userId;
    private int age;
    private LocalDateTime created;

    // domain operation
    public void addAge() {
        this.age++;
        registerEvent(new CustomEvent(this,"user age is "+this.age));
    }
}