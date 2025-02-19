package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;
}
