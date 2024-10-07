package dima.evseenko.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();
    private final Set<String> forbiddenWords = Set.of(
            "fuck",
            "dick",
            "pussy"
    );

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (Objects.nonNull(type) && Objects.nonNull(handler)) {
            notificationHandlers.put(type, handler);
        }
    }

    public void sendNotification(Notification notification) {
        validateNotificationMassage(notification);

        if (notificationHandlers.containsKey(notification.getType())) {
            notificationHandlers.get(notification.getType()).accept(notification);
        }
    }

    public Consumer<Notification> getNotificationHandler(NotificationType type) {
        return notificationHandlers.get(type);
    }

    private void validateNotificationMassage(Notification notification) {
        if (Objects.nonNull(notification)) {
            forbiddenWords.forEach((word) -> {
                if (notification.getMessage().toLowerCase().contains(word.toLowerCase())) {
                    notification.setMessage(notification.getMessage().replace(word.toLowerCase(), "*"));
                }
            });
        }
    }
}
