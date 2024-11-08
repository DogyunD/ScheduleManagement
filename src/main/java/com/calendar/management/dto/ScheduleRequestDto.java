package com.calendar.management.dto;


import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String task;

    private String author;

    private Long password;

    private String creatAt;

    private String patchAt;
}
