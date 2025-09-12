package school.faang.bjs2_87671;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}
