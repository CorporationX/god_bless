package faang.school.godbless.sprint_3.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notificationMap.containsKey(notification.getType())) {
            notificationMap.get(notification.getType()).accept(notification);
        } else {
            throw new IllegalArgumentException("The type is not registered");
        }
    }
}
