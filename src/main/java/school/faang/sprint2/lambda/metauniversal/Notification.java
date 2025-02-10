package school.faang.sprint2.lambda.metauniversal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;
}
