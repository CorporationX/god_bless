package school.faang.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private NotificationType type;
    private String message;
}
