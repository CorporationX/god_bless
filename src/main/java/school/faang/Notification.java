package school.faang;

import lombok.Getter;

@Getter
public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        validateNotificationType(type);
        validateMessage(message);
        this.type = type;
        this.message = message;
    }

    private void validateNotificationType(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("The NotificationType can't be null.");
        }
    }

    private void validateMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("The message can't be null or blank. " +
                    "Provided value: '" + message + "'");
        }
    }
}
