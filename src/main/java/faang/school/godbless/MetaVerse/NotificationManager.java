package faang.school.godbless.MetaVerse;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notificationHandlers.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandlers
                .getOrDefault(notification.getType(), errorNotification ->
                        System.out.println("No handler found for notification type: " + errorNotification.getType()));
        handler.accept(notification);
    }
}
