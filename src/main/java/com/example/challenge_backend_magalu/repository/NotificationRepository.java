package com.example.challenge_backend_magalu.repository;

import com.example.challenge_backend_magalu.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
