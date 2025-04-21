package school.faang.bjs2_70675;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private final NotificationType type;
    private String message;
}
