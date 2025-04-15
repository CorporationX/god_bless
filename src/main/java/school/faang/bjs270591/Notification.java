package school.faang.bjs270591;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
}