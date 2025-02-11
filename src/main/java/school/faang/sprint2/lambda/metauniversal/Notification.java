package school.faang.sprint2.lambda.metauniversal;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType notificationType;
    private final String message;
}
