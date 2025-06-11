package school.faang.bjs280575;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private NotificationType type;
    private String message;
}
