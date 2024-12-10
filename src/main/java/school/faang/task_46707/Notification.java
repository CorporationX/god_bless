package school.faang.task_46707;

import lombok.Getter;

@Getter
public class Notification {
    private final String type;
    private final String message;

    public Notification(String type, String message) {
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

    private static void validateType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type don't be null or empty!");
        }
    }
}
