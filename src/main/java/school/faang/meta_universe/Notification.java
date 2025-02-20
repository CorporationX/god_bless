package school.faang.meta_universe;

import lombok.Getter;

@Getter
public class Notification {

    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}
