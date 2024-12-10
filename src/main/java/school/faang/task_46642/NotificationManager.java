package school.faang.task_46642;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.type());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Handler for type \"" + notification.type() + "\" not found.");
        }
    }

    public void addFilter(String keyword, Consumer<Notification> handler) {
        registerHandler("filter_" + keyword, handler);
    }

    public void processFilters(Notification notification) {
        for (Map.Entry<String, Consumer<Notification>> entry : handlers.entrySet()) {
            if (entry.getKey().startsWith("filter_")) {
                entry.getValue().accept(notification);
            }
        }
    }
}