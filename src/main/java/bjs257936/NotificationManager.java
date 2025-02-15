package bjs257936;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATION_TO_CONSUMER = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        NOTIFICATION_TO_CONSUMER.put(type.getText(), handler);
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(NOTIFICATION_TO_CONSUMER.get(notification.getType().getText())).accept(notification);
    }
}
