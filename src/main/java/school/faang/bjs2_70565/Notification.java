package school.faang.bjs2_70565;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Notification {
    private NotificationType type;
    @Setter
    private String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}
