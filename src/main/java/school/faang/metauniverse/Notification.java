package school.faang.metauniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}
