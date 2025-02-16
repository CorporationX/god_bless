package school.faang;

import lombok.Data;

@Data
public class Notification {
    private NotificationType type;
    private String message;

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
