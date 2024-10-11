package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationsHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notificationHandler) {
        notificationsHandlers.put(type, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        if (notificationsHandlers.containsKey(notification.type())) {
            notificationsHandlers.get(notification.type()).accept(notification);
        } else {
            System.out.printf("Для типа оповещения %s отсутствует обработчик%n", notification.type());
        }
    }
}
