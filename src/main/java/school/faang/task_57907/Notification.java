package school.faang.task_57907;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NonNull
public class Notification {
    @NonNull
    private final NotificationType type;

    @NonNull
    private String message;
}
