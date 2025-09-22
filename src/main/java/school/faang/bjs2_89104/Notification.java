package school.faang.bjs2_89104;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private NotificationType type;
    private String message;
}
