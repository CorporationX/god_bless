package school.faang.meta;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Slf4j
public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationHandlersByType =
            new EnumMap<>(NotificationType.class);
    private final Map<NotificationType, Predicate<Notification>> filterHandlersByType =
            new EnumMap<>(NotificationType.class);
    private final Map<NotificationType, UnaryOperator<Notification>> correctorHandlersByType =
            new EnumMap<>(NotificationType.class);

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> handler) {
        notificationHandlersByType.put(type, handler);
        log.info("Registered notification handler for type {}", type);
    }

    public void registerHandler(@NonNull NotificationType type, @NonNull Predicate<Notification> handler) {
        filterHandlersByType.put(type, handler);
        log.info("Registered predicate handler for type {}", type);
    }

    public void registerHandler(@NonNull NotificationType type, @NonNull UnaryOperator<Notification> handler) {
        correctorHandlersByType.put(type, handler);
        log.info("Registered corrector handler for type {}", type);
    }

    public void sendNotification(@NonNull Notification notification) {
        var filterHandler = filterHandlersByType.get(notification.type());
        if (filterHandler != null && !filterHandler.test(notification)) {
            log.info("Notification {} rejected", notification);
            return;
        }
        var correctorHandler = correctorHandlersByType.get(notification.type());
        if (correctorHandler != null) {
            notification = correctorHandler.apply(notification);
            log.info("Notification {} updated", notification);
        }
        var notificationHandler = notificationHandlersByType.get(notification.type());
        if (notificationHandler != null) {
            notificationHandler.accept(notification);
            log.info("Notification {} sent", notification);
        } else {
            log.info("Notification {} not sent", notification);
        }
    }
}
