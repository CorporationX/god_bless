package school.faang.metaverse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private final NotificationType type;
    private final String message;
}
