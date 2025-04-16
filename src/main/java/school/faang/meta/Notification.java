package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private NotificationType type;
    private String massage;
}