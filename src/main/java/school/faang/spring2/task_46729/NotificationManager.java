package school.faang.spring2.task_46729;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        map.putIfAbsent(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = map.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
