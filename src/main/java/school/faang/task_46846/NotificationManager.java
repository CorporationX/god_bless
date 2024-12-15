package school.faang.task_46846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<Types, Consumer<Notification>> typesConsumers = new HashMap<>();

    public void registerHandler(Types type, Consumer<Notification> consumer) {
        if (type == null || consumer == null) {
            throw new IllegalArgumentException("Paramaters can not be null");
        }
        typesConsumers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification can not be null");
        } else if (notification.getType() == null) {
            throw new IllegalArgumentException("Notifications type can not be null");
        }
        typesConsumers.get(notification.getType()).accept(notification);
    }
}
