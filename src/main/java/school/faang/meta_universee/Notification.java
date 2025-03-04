package school.faang.meta_universee;

import java.util.Objects;

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
        PUSH
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
