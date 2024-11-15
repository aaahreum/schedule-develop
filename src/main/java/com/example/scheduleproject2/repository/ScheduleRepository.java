package com.example.scheduleproject2.repository;

import com.example.scheduleproject2.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
