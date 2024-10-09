package dima.evseenko.meta;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class NotificationManager {
    public static final Set<String> forbiddenWords = Set.of(
            "fuck",
            "dick",
            "pussy"
    );

    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(@NotNull NotificationType type, @NotNull Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
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

    private void validateNotificationMassage(@NotNull Notification notification) {
        forbiddenWords.forEach((word) -> {
            if (notification.getMessage().toLowerCase().contains(word.toLowerCase())) {
                notification.setMessage(notification.getMessage().replace(word.toLowerCase(), "*"));
            }
        });
    }
}
