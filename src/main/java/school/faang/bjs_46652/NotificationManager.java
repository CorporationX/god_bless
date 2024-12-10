package school.faang.bjs_46652;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Predicate<String>> filters = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        try {
            NotificationType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No handler registered for " + type);
        }
        handlers.put(type, handler);
    }

    public void registerFilter(String name, Predicate<String> filter) {
        filters.put(name, filter);
    }

    public boolean sendNotification(Notification notification) {
        String notificationType = notification.getNotificationType().name().toLowerCase();
        Consumer<Notification> consumer = handlers.get(notificationType);

        boolean valid = validateMessage(notification.getMessage());
        if (consumer == null || !valid) {
            return false;
        }

        consumer.accept(notification);
        return true;
    }

    public boolean validateMessage(String message) {
        return filters.values().stream()
                .map(filter -> filter.test(message))
                .filter(filter -> !filter)
                .findAny()
                .orElse(true);
    }

    public List<String> getRegisteredHandlers() {
        return List.copyOf(handlers.keySet());
    }

    public void unregisterAllHandlers() {
        handlers.clear();
    }

    public List<String> getRegisteredFilters() {
        return List.copyOf(filters.keySet());
    }

    public void unregisterAllFilters() {
        filters.clear();
    }


}
