package school.faang.task_469996;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> typeAction = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        typeAction.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        typeAction.get(notification.getType()).accept(notification);
    }
}
