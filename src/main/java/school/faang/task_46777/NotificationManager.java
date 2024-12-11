package school.faang.task_46777;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationMap = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        notificationMap.get(notification.getType()).registerHandler(notification);
    }
}
