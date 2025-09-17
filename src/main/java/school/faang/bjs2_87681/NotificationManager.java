package school.faang.bjs2_87681;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final Predicate<String> containBadWord = s -> s.contains("оскорбление");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification, "Notification cannot be null");

        validateBadWords(notification, containBadWord);
        notificationHandlers.get(notification.getType()).accept(notification);
    }

    public void validateBadWords(Notification notification, Predicate<String> filter) {
        if (filter.test(notification.getMessage())) {
            throw new IllegalArgumentException("Переданное сообщение содержит оскорбления");
        }
    }
}
