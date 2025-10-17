package school.faang.s2.func_int.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType,Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }
    public void sendNotification(Notification notification) {
        if (handlers.containsKey(notification.getType())) {
            handlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Не найден обработчик для типа: " + notification.getType());
        }
    }

}