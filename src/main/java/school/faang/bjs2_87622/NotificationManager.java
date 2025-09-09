package school.faang.bjs2_87622;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import school.faang.bjs2_87622.Notification.NotificationType;

public class NotificationManager {
    private static final Map<NotificationType, Consumer<Notification>> notificationManager = new HashMap<>();

    private NotificationManager() {

    }

    public static void registerNotificationHandler(NotificationType type, Consumer<Notification> handler) {
        notificationManager.put(type, handler);
    }

    public static void sendNotification(Notification notification) {
        if (notification.message() == null || notification.message().isBlank()) {
            throw new IllegalArgumentException("notification message can not be null, empty or a space");
        }
        Consumer<Notification> handler = notificationManager.get(notification.type());
        handler.accept(notification);
    }
}