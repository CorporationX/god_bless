package school.faang.task46593;

import lombok.Getter;

@Getter
public class Notification {
    private final TypeOfNotification type;
    private final String message;

    public Notification(TypeOfNotification type, String message) {
        validation(type, message);

        this.type = type;
        this.message = message;
    }

    private void validation(TypeOfNotification type, String message) {
        if (type == null) {
            throw new IllegalArgumentException("type is null");
        }
        if (message == null) {
            throw new IllegalArgumentException("message is null");
        }
    }
}
