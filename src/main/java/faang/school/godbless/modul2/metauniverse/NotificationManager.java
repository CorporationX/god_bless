package faang.school.godbless.modul2.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        notificationHandlers.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (!notificationHandlers.containsKey(notification.getType())) {
            throw new IllegalArgumentException("No handler with this name");
        }
        notificationHandlers.get(notification.getType()).accept(notification);
    }
}

