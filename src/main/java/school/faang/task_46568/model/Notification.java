package school.faang.task_46568.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {
    private final NotificationType type;
    private final String message;
}
