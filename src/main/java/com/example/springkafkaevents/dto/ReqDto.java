package com.example.springkafkaevents.dto;

import com.example.springkafkaevents.validator.IsNullToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReqDto {
    @IsNullToString
    private String name;
    private int age;

    private int userNo;
}
