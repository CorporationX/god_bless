package school.faang.task_46766;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Notification {
    private final NotificationType notificationType;
    private String message;
}