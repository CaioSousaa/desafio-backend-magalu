package com.example.challenge_backend_magalu.service;

import com.example.challenge_backend_magalu.controller.dto.ScheduleNotification;
import com.example.challenge_backend_magalu.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void scheduleNotification(ScheduleNotification scheduleNotifications) {
        notificationRepository.save(scheduleNotifications.toNotification());
    }

}
