package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers;

    public NotificationManager() {
        handlers = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (handlers.containsKey(notification.getType())) {
            handlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Обработчик для типа оповещения " + notification.getType() + " не найден.");
        }
    }
}
