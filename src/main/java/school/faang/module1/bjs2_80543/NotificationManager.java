package school.faang.module1.bjs2_80543;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<NotificationType, List<Predicate<Notification>>> filtersByType = new HashMap<>();
    private final Map<NotificationType, List<Function<Notification, Notification>>> correctorsByType = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type must not be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler must not be null");
        }
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null");
        }
        if (notification.getNotificationType() == null) {
            throw new IllegalArgumentException("Notification type must not be null");
        }

        if (!passesFilters(notification)) {
            log.warn("Notification was not sent due to failing filter: {}", notification.getMessage());
            return;
        }

        notification = applyCorrectors(notification);

        if (!handleNotification(notification)) {
            log.warn("No handler found for notification type: {}", notification.getNotificationType());
        }
    }

    private boolean passesFilters(Notification notification) {
        List<Predicate<Notification>> filters =
                filtersByType.getOrDefault(notification.getNotificationType(), Collections.emptyList());
        for (Predicate<Notification> filter : filters) {
            if (!filter.test(notification)) {
                return false;
            }
        }
        return true;
    }

    private Notification applyCorrectors(Notification notification) {
        List<Function<Notification, Notification>> correctors =
                correctorsByType.getOrDefault(notification.getNotificationType(), Collections.emptyList());
        for (Function<Notification, Notification> corrector : correctors) {
            notification = corrector.apply(notification);
            if (notification == null) {
                throw new IllegalStateException("Corrector must not return null");
            }
        }
        return notification;
    }

    private boolean handleNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getNotificationType());
        if (handler != null) {
            handler.accept(notification);
            return true;
        }
        return false;
    }

    public void registerFilter(NotificationType notificationType, Predicate<Notification> predicate) {
        if (notificationType == null) {
            throw new IllegalArgumentException("Notification type must not be null");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        filtersByType.computeIfAbsent(notificationType, type -> new ArrayList<>()).add(predicate);
    }

    public void registerCorrector(NotificationType notificationType,
                                  Function<Notification, Notification> corrector) {
        if (notificationType == null) {
            throw new IllegalArgumentException("Notification type must not be null");
        }
        if (corrector == null) {
            throw new IllegalArgumentException("Corrector must not be null");
        }
        correctorsByType.computeIfAbsent(notificationType, type -> new ArrayList<>()).add(corrector);
    }
}