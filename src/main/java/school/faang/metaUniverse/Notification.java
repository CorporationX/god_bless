package school.faang.metaUniverse;

public class Notification {
    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
