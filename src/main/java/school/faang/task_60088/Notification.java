package school.faang.task_60088;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}
