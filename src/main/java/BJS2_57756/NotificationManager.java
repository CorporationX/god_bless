package BJS2_57756;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> consumers = new HashMap<>();
    private final List<String> badwordsList = List.of("fuck", "suicide", "bitch");
    private final Function<Notification, Notification> notificationChanger = notification
            -> new Notification(notification.getType(), notification.getMessage() + " (c) Company name");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        consumers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notification = notificationChanger.apply(notification);
        Notification finalNotification = notification;
        badwordsList.stream()
                .filter(badWord -> finalNotification.getMessage().contains(badWord))
                .findFirst()
                .ifPresent(badWord -> {
                    throw new IllegalArgumentException("This message contains a bad word: " + badWord);
                });

        if (consumers.get(notification.getType()) != null) {
            consumers.get(notification.getType()).accept(notification);
        }
    }
}
