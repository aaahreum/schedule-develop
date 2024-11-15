package com.example.scheduleproject2.dto;

import com.example.scheduleproject2.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    // toDto()를 활용해서 Entity를 Dto로 변환
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }
}
