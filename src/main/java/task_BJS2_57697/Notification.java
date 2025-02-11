package task_BJS2_57697;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private final String signature = "\nС уважением,\nВаш notifyService!\n";
    private NotificationType type;
    private String message;
}
