package school.faang.task_46701;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();
    private final Map<String, Predicate<Notification>> filters = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> correctors = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        notificationTypeCheck(notificationType);
        if (handler == null) {
            throw new IllegalArgumentException("handler не может быть null");
        }
        handlers.put(notificationType, handler);
    }

    public void registerFilter(String notificationType, Predicate<Notification> filter) {
        notificationTypeCheck(notificationType);
        if (filter == null) {
            throw new IllegalArgumentException("filter не может быть null");
        }
        filters.put(notificationType, filter);
    }

    public void registerCorrector(String notificationType, Function<Notification, Notification> corrector) {
        notificationTypeCheck(notificationType);
        if (corrector == null) {
            throw new IllegalArgumentException("corrector не может быть null");
        }
        correctors.put(notificationType, corrector);
    }

    public void sendNotification(Notification notification) {
        Predicate<Notification> filter = filters.get(notification.getType());
        if (filter != null && !filter.test(notification)) {
            System.out.println("Notification filtered out: " + notification);
            return;
        }
        Function<Notification, Notification> corrector = correctors.get(notification.getType());
        if (corrector != null) {
            notification = corrector.apply(notification);
        }

        Optional.ofNullable(handlers.get(notification.getType()))
                .orElseThrow(() -> new IllegalArgumentException("No handler found for notification type: " + notification.getType()))
                .accept(notification);
    }

    private void notificationTypeCheck(String notificationType) {
        if (notificationType == null || notificationType.isEmpty()) {
            throw new IllegalArgumentException("notificationType не может быть пустым");
        }
    }
}
