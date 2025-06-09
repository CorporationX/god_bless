package school.faang.bjs2_80501;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> groupedHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (isInvalidHandler(handler)) {
            log.warn("Invalid handler");
            return;
        }

        groupedHandlers.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification, Predicate<String> filter) {
        if (isInvalidNotification(notification) || isInvalidPredicate(filter)) {
            log.warn("Invalid argument");
            return;
        }

        if (!filter.test(notification.getMessage())) {
            log.warn("This notification cannot be send: unacceptable message");
            return;
        }

        groupedHandlers.getOrDefault(notification.getType(), (param) ->
                log.warn("Message will not sent: no handler registered for type %s"
                        .formatted(notification.getType())))
                .accept(notification);
    }

    private boolean isInvalidType(NotificationType type) {
        return type == null;
    }

    private boolean isInvalidHandler(Consumer<Notification> handler) {
        return handler == null;
    }

    private boolean isInvalidNotification(Notification notification) {
        return isInvalidType(notification.getType()) || !notification.hasMessage();
    }

    private boolean isInvalidPredicate(Predicate<String> filter) {
        return filter == null;
    }

}
