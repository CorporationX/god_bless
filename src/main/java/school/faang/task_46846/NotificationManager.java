package school.faang.task_46846;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> typesConsumers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        typesConsumers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        typesConsumers.get(notification.getType()).accept(notification);
    }
}
