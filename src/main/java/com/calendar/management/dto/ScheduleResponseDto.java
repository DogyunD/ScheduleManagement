package com.calendar.management.dto;

import com.calendar.management.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;

    private String task;

    private String author;

    private Long password;

    private String creatAt;

    private String patchAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.author = schedule.getAuthor();
        this.password = schedule.getPassword();
        this.creatAt = schedule.getCreatAt();
        this.patchAt = schedule.getPatchAt();
    }
}
