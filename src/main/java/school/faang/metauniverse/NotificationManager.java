package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATION_HANDLERS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationHandler) {
        NOTIFICATION_HANDLERS.put(type, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        if (NOTIFICATION_HANDLERS.containsKey(notification.getType())) {
            NOTIFICATION_HANDLERS.get(notification.getType()).accept(notification);
        } else {
            System.out.printf("Для типа оповещения :%s отсутствует обработчик%n", notification.getType());
        }
    }
}
