package school.faang.meta;

import lombok.Getter;

@Getter
public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}
