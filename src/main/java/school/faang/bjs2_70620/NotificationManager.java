package school.faang.bjs2_70620;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersByType = new HashMap<>();
    private final Map<NotificationType, Predicate<String>> messageFiltersByNotificationType = new HashMap<>();

    public Consumer<Notification> registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (type == null) {
            throw new NullPointerException("Notification type if null");
        } else if (handler == null) {
            throw new NullPointerException("Handler is null");
        }
        return notificationHandlersByType.put(type, handler);
    }

    public Predicate<String> registerFilter(NotificationType type, Predicate<String> filter) {
        if (type == null) {
            throw new NullPointerException("Notification type is null");
        } else if (filter == null) {
            throw new NullPointerException("Filter is null");
        }
        return messageFiltersByNotificationType.put(type, filter);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("Notification if null");
        } else if (notification.getMessage() == null) {
            throw new NullPointerException("Notification message if null");
        } else if (notification.getNotificationType() == null) {
            throw new NullPointerException("Notification type if null");
        }
        Consumer<Notification> handler = Optional.ofNullable(notificationHandlersByType.get(
                notification.getNotificationType())).orElseThrow(() -> new NoSuchElementException(String.format(
                "Handler for notification with type %s not found", notification.getNotificationType())));
        Predicate<String> filter = messageFiltersByNotificationType.getOrDefault(notification.getNotificationType(),
                text -> text != null && text.toLowerCase().contains("ass"));
        if (!filter.test(notification.getMessage())) {
            handler.accept(notification);
        } else {
            log.error("Your message contains bad words. We don't able to send it.");
        }
    }
}