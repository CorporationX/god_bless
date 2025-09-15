package school.faang.bjs2_87681;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private final String message;
}