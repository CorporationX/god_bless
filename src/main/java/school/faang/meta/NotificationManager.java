package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static final String NOTIFICATION_ERROR = "Нет уведомлени";
    private final Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> consumer) {
        if (notification == null || notification.isBlank()) {
            throw new IllegalArgumentException(NOTIFICATION_ERROR);
        }
        if (consumer == null) {
            throw new IllegalArgumentException("Потребитель не был указан");
        }
        notificationHandler.put(notification, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException(NOTIFICATION_ERROR);
        }
        if (notificationHandler.containsKey(notification.getType())) {
            notificationHandler.get(notification.getType()).accept(notification);
        }
    }
}
