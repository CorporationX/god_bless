package school.faang.bjs2_57888;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {

    private NotificationType type;
    private String message;

}
