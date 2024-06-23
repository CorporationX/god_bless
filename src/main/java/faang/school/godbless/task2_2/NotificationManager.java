package faang.school.godbless.task2_2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String id, Consumer<Notification> consumer) {
        notifications.put(id, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notifications.containsKey(notification.getType())) {
            notifications.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Уведомление не найдено");
        }
    }
}
