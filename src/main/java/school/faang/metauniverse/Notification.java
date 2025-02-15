package school.faang.metauniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    public final NotificationType type;
    public final String message;
}
