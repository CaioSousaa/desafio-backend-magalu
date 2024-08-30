package com.example.challenge_backend_magalu.controller;

import com.example.challenge_backend_magalu.controller.dto.ScheduleNotification;
import com.example.challenge_backend_magalu.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
@NoArgsConstructor
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotification dto) {
            notificationService.scheduleNotification(dto);

            return ResponseEntity.accepted().build();
    }
}
