package school.faang;

import lombok.Data;

@Data
public class Notification {
    NotificationType type;
    String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }

    public enum NotificationType {
        EMAIL,
        SMS,
        PUSH;
    }
}
