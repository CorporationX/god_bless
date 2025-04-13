package school.faang.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}