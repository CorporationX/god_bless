package school.faang.sprint2.task_46640;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Notification {
    @NonNull
    private final NotificationType type;
    @NonNull
    private final String message;
}
