package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;
}
