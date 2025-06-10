package school.faang.module1.bjs2_80543;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private final NotificationType notificationType;
    private final String message;
}