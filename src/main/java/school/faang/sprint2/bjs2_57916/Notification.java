package school.faang.sprint2.bjs2_57916;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(@NonNull NotificationType type, @NonNull String message) {
        if (message.isBlank()) {
            log.error("Сообщение не может состоять из пробелов");
            throw new IllegalArgumentException("Сообщение не может состоять из пробелов");
        }
        this.type = type;
        this.message = message;
    }
}
