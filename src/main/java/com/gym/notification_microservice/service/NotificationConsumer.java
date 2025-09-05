package com.gym.notification_microservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.gym.notification_microservice.dto.NotificationDTO;

public class NotificationConsumer {
    
    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = "notification.queue")
    public void receiveNotification(NotificationDTO notification) {
        notificationService.sendNotification(notification);
    }
}
