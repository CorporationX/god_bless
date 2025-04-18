package school.faang.BJS270636;

public class Notification {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private String message;
    private NotificationType type;

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
