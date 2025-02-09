package school.faang.meta;

import lombok.Data;

@Data

public class Notification {
    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}
