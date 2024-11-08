package com.calendar.management.controller;

import com.calendar.management.dto.ScheduleRequestDto;
import com.calendar.management.dto.ScheduleResponseDto;
import com.calendar.management.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule>schedules = new HashMap<>();

    //일정 등록
    @PostMapping
    public ScheduleResponseDto create(@RequestBody ScheduleRequestDto dto) {
        Long scheduleId = schedules.isEmpty() ? 1 : Collections.max(schedules.keySet()) +1;

       Schedule schedule =  new Schedule(scheduleId, dto.getTask(), dto.getAuthor(),
                            dto.getPassword(), dto.getCreatAt(), dto.getPatchAt());

       schedules.put(scheduleId, schedule);

       return new ScheduleResponseDto(schedule);
    }

    //생성된 일정 선택 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long id) {

        Schedule schedule = schedules.get(id);

        return new ScheduleResponseDto(schedule);
    }

    // 생성된 일정 수정
    @PutMapping("/{id}")
    public ScheduleResponseDto updateMemoById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {
        Schedule schedule = schedules.get(id);

        schedule.patch(requestDto);

        return new ScheduleResponseDto(schedule);
    }

    // 선택한 일정 삭제
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        schedules.remove(id);
    }
}
