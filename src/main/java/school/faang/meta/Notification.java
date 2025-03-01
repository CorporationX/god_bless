package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private final NotificationType type;
    private final String message;
}
