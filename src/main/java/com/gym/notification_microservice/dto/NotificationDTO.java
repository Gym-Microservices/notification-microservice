package com.gym.notification_microservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for sending notifications")
public class NotificationDTO implements Serializable {
    @Schema(description = "ID of the recipient user", example = "1", required = true)
    private Long userId;
    @Schema(description = "Notification message", example = "Your class has been scheduled successfully", required = true)
    private String message;
}
