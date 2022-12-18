package com.example.springkafkaevents;

import com.example.springkafkaevents.dto.ReqDto;
import com.example.springkafkaevents.entity.User;
import com.example.springkafkaevents.event.CustomEventPublisher;
import com.example.springkafkaevents.event.GenericEventPublisher;
import com.example.springkafkaevents.service.DomainService;
import com.example.springkafkaevents.validator.ValidationFactory;
import java.time.LocalDateTime;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
//@Validated
public class EventController {

    private final CustomEventPublisher customEventPublisher;
    private final GenericEventPublisher<String> genericEventPublisher;

    private final DomainService domainService;

    private final ValidationFactory validationFactory;

    @GetMapping("/event")
    public String event(@RequestParam String message) {
        validationFactory.find("A");
        customEventPublisher.publish(message);
        return "finished";
    }

    @GetMapping("/event/generic")
    public String event(@RequestParam String message, @RequestParam boolean success) {
        genericEventPublisher.publish(message, success);
        return "finished";
    }

    @GetMapping("/event/user")
    public String eventMessage(@RequestParam String userId) {
        User user = User.builder().userNo(1).userId(userId).age(30)
            .created(LocalDateTime.now()).build();
        domainService.save(user);
        System.out.println("userId = " + userId);
        domainService.addAge(userId);
        return "finished";
    }

    @PostMapping("/event")
    public String addEvents(@RequestBody @Valid ReqDto reqDto) {
        domainService.save(User.builder()
            .userNo(reqDto.getUserNo())
            .userId(reqDto.getName())
            .age(reqDto.getAge())
            .build());
        domainService.addAge(reqDto.getName());
        return "finished";
    }
}
