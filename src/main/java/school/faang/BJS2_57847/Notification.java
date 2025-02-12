package school.faang.BJS2_57847;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;
}
