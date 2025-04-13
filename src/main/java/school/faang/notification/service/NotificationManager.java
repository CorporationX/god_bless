package school.faang.notification.service;

import lombok.extern.slf4j.Slf4j;
import school.faang.notification.model.Notification;
import school.faang.notification.model.NotificationType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private static final Function<Notification, Notification> ADD_SIGNATURE = notification ->
            new Notification(notification.getType(), notification.getMessage() + " - Meta Team");

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final List<Predicate<Notification>> filters = new ArrayList<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void addFilter(Predicate<Notification> filter) {
        filters.add(filter);
    }

    public void sendNotification(Notification notification) {
        if (!isAllowed(notification)) {
            log.warn("Notification blocked by filter: {}", notification.getMessage());
        } else {
            Consumer<Notification> handler = handlers.get(notification.getType());
            if (handler != null) {
                handler.accept(ADD_SIGNATURE.apply(notification));
            } else {
                log.warn("No handler for type: {}", notification.getType());
            }
        }
    }

    private boolean isAllowed(Notification notification) {
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                return false;
            }
        }
        return true;
    }
}