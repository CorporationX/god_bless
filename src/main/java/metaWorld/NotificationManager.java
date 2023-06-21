package metaWorld;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String identificator, Consumer<Notification> notificationConsumer) {
        notifications.put(identificator, notificationConsumer);
    }

    public void sendNotification(@NotNull Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
