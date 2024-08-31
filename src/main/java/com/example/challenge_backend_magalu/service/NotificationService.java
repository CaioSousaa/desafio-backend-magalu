package com.example.challenge_backend_magalu.service;

import com.example.challenge_backend_magalu.controller.dto.ScheduleNotification;
import com.example.challenge_backend_magalu.entity.Notification;
import com.example.challenge_backend_magalu.entity.Status;
import com.example.challenge_backend_magalu.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void scheduleNotification(ScheduleNotification scheduleNotifications) {
        notificationRepository.save(scheduleNotifications.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
       var notification = findById(notificationId);

       if(notification.isPresent()) {
           notification.get().setStatus(Status.Values.CANCELED.toStatus());
           notificationRepository.save(notification.get());
       }
    }

}
