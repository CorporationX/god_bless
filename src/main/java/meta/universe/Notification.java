package meta.universe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}
