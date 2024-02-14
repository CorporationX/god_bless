package faang.school.godbless.r_edzie.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATIONS_HANDLERS = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        NOTIFICATIONS_HANDLERS.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationHandler = NOTIFICATIONS_HANDLERS.get(notification.getType());

        if (notificationHandler == null) {
            throw new NoSuchElementException("Handler does not exist");
        }

        notificationHandler.accept(notification);
    }
}
