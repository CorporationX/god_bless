package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    NotificationType type;
    String message;
}
