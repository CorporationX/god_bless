package bjs257936;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private NotificationType type;
    private String message;
}
