package school.faang.task_46846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<Types, Consumer<Notification>> typesConsumers = new HashMap<>();

    public void registerHandler(Types type, Consumer<Notification> consumer) {
        typesConsumers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification can not be null");
        }
        typesConsumers.get(notification.getType()).accept(notification);
    }
}
