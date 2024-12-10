package school.faang.bjs_46652;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        try {
            NotificationType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No handler registered for " + type);
        }
        handlers.put(type, handler);
    }

    public boolean sendNotification(Notification notification) {
        String notificationType = notification.getNotificationType().name().toLowerCase();
        Consumer<Notification> consumer = handlers.get(notificationType);

        if (consumer == null) {
            return false;
        }

        consumer.accept(notification);
        return true;
    }

    public List<String> getRegisteredHandlers() {
        return List.copyOf(handlers.keySet());
    }

    public void unregisterAllHandlers() {
        handlers.clear();
    }
}
