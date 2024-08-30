package com.example.challenge_backend_magalu.controller.dto;

import com.example.challenge_backend_magalu.entity.Channel;
import com.example.challenge_backend_magalu.entity.Notification;
import com.example.challenge_backend_magalu.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotification(LocalDateTime dateTime,
                                   String destination,
                                   String message,
                                   Channel.Values channel) {


    public Notification toNotification() {
        return new Notification(
                dateTime,
                message,
                destination,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
