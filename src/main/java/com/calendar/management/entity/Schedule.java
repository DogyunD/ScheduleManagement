package com.calendar.management.entity;

import com.calendar.management.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;

    private String task;

    private String author;

    private Long password;

    private String creatAt;

    private String patchAt;

    public void patch(ScheduleRequestDto dto){
        this.task = dto.getTask();
        this.author = dto.getAuthor();
        this.password = dto.getPassword();
        this.creatAt = dto.getCreatAt();
    }
}
