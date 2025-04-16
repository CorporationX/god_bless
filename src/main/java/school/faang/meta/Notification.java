package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Notification {
    private final NotificationType notificationType;
    private final String message;
}
