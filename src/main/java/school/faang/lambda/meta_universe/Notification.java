package school.faang.lambda.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}
