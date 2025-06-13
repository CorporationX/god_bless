package school.faang.bjs280619;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private NotificationType type;
    private String message;
}
