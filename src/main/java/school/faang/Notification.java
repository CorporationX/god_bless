package school.faang;

public class Notification {

    public enum NotificationType {
    EMAIL, SMS, PUSH
    }

    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}