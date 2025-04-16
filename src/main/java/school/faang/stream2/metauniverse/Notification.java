package school.faang.stream2.metauniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    NotificationType type;
    String message;
}
