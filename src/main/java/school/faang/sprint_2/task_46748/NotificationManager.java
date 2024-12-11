package school.faang.sprint_2.task_46748;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.type());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Не найден обработчик для " + notification.type());
        }
    }
}
