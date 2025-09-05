package com.gym.notification_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.notification_microservice.dto.NotificationDTO;
import com.gym.notification_microservice.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    
    @PostMapping
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationDTO notification) {
        notificationService.sendNotification(notification);
        return ResponseEntity.ok().build();
    }
}
