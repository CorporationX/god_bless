package school.faang.task_46707;

import lombok.Getter;

@Getter
public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        validateType(type);
        validateMessage(message);

        this.type = type;
        this.message = message;
    }

    private static void validateMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message don't be null or empty!");
        }
    }

    private static void validateType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type don't be null!");
        }
    }
}
