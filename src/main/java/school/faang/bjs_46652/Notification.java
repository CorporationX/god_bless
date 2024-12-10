package school.faang.bjs_46652;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private final NotificationType notificationType;
    private final String message;
}
