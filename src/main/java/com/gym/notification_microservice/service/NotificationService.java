package com.gym.notification_microservice.service;

import org.springframework.stereotype.Service;

import com.gym.notification_microservice.dto.NotificationDTO;

@Service
public class NotificationService {
    public void sendNotification(NotificationDTO notification) {
        System.out.println("Sending notification to user: " + notification.getUserId() + " with message: " + notification.getMessage());
    }
}
