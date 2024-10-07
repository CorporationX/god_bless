package school.faangSprint2.t2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers;

    public NotificationManager() {
        this.handlers = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = handlers.get(type);

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Обработчик для такого типа '" + type + "' отсутствует.");
        }
    }
}