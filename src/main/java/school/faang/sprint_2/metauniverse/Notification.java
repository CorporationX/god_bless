package school.faang.sprint_2.metauniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private NotificationType type;
    private String message;
}
