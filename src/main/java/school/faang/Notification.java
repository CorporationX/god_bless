package school.faang;

public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Notification { type: " + type + ", message: " + message + "}";
    }

}
