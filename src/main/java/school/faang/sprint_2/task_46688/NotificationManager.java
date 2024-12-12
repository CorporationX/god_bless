package school.faang.sprint_2.task_46688;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationProcessing = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        notificationProcessing.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        for (var entry : notificationProcessing.entrySet()) {
            if (notification.type().equals(entry.getKey())) {
                entry.getValue().accept(notification);
            }
        }
    }
}