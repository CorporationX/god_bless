package school.faang.task_46680;

import java.util.HashMap;
import java.util.function.Consumer;

public class NotificationManager {
    private HashMap<String, Consumer<Notification>> notifications = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notification) {
        notifications.put(type, notification);
    }

    public void sendNotification(Notification object) {
      notifications.get(object.getType()).accept(object);
    }
}
