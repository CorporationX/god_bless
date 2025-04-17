package school.faang.stream2.metauniverse;

import lombok.Data;

@Data
public class Notification {
    private final NotificationType type;
    private final String message;
}
