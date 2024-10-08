package school.faang.BJS2_34731_MetaUniverse;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

public class NotificationManager {
    private HashMap<String, Consumer<Notification>> handlersByNotificationsTypes;

    public NotificationManager() {
        handlersByNotificationsTypes = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> notificationHandler) {
        if (notificationType == null || notificationHandler == null) {
            throw new IllegalArgumentException("Notification type or its handler can't be null.");
        }
        handlersByNotificationsTypes.put(notificationType, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Notification can't be null.");
        }
        Optional.ofNullable(handlersByNotificationsTypes.get(notification.getType()))
                .ifPresentOrElse(
                        handler -> handler.accept(notification),
                        () -> System.out.println("Unknown type of notification.")
                );
    }
}
