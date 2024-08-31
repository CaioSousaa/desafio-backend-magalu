package com.example.challenge_backend_magalu.service;

import com.example.challenge_backend_magalu.controller.dto.ScheduleNotification;
import com.example.challenge_backend_magalu.entity.Notification;
import com.example.challenge_backend_magalu.entity.Status;
import com.example.challenge_backend_magalu.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

    public void checkAndSend(LocalDateTime dateTime) {
        var notification = notificationRepository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()),
                dateTime
        );

        notification.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }

}
