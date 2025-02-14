package school.faang.sprint2.task_57659;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;
}
