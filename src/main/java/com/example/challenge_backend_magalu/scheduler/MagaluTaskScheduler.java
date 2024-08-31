package com.example.challenge_backend_magalu.scheduler;


import com.example.challenge_backend_magalu.service.NotificationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class MagaluTaskScheduler {


   private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

   @Autowired
   private final NotificationService notificationService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTasks() {
        var dateTime = LocalDateTime.now();

        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }

}
