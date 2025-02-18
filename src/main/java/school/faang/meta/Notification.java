package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private NotificationType type;
    private String message;
}
