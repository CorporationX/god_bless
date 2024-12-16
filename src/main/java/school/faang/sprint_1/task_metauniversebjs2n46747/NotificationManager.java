package school.faang.sprint_1.task_metauniversebjs2n46747;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private final Map<String, Consumer<Notification>> mapNotification = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        mapNotification.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = mapNotification.get(notification.getType());
        consumer.accept(notification);

    }
}
