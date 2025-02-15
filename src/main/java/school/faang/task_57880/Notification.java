package school.faang.task_57880;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;
}
