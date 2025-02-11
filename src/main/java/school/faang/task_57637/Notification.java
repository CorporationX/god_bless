package school.faang.task_57637;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    @Setter
    private  String message;
}
