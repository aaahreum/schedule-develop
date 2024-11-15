package com.example.scheduleproject2.service;

import com.example.scheduleproject2.dto.ScheduleResponseDto;
import com.example.scheduleproject2.entity.Schedule;
import com.example.scheduleproject2.entity.User;
import com.example.scheduleproject2.repository.ScheduleRepository;
import com.example.scheduleproject2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String title, String contents, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);

        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());

    }
}
