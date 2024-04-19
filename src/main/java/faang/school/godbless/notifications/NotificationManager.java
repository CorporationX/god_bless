package faang.school.godbless.notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        handlers.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        handlers.getOrDefault(notification.getType(), handlers.get("defaultValue"));
    }
}
