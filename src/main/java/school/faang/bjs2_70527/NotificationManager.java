package school.faang.bjs2_70527;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandler = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = notificationHandler.get(notification.type());
        if (notificationConsumer == null) {
            throw new NotificationTypeNotFoundException(
                    String.format("Notification with notification type %s not found", notification.type().toString()));
        }
        notificationConsumer.accept(notification);
    }
}
