package school.faang.sprint_2.task_46748;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type != null && handler != null) {
            handlers.put(type, handler);
        } else {
            System.out.println("Type равен NULL или Handler равен NULL");
        }
    }

    void sendNotification(Notification notification) {
        if (notification != null) {
            Consumer<Notification> handler = handlers.get(notification.type());
            if (handler != null) {
                handler.accept(notification);
            } else {
                System.out.println("Не найден обработчик для " + notification.type());
            }
        } else {
            System.out.println("Notification равен NULL");
        }

    }
}
