package school.faang.sprinttwo.metauniverse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private NotificationType notificationType;
    private String message;

    public Notification withMessage(String newMessage) {
        return new Notification(notificationType, newMessage);
    }
}