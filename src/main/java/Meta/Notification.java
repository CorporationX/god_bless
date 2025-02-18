package Meta;

public class Notification {
    private final NotificationType type;
    private final String message;

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

    @Override
    public String toString() {
        return "Notification{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
