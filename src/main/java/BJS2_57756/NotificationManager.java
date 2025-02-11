package BJS2_57756;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> consumers = new HashMap<>();
    private final List<String> badwordsList = List.of("fuck", "suicide", "bitch");
    private final Predicate<Notification> predicate = notification -> badwordsList.stream().anyMatch(
            badword -> notification.getMessage().contains(badword));
    private final Function<Notification, Notification> notificationChanger = notification
            -> new Notification(notification.getType(), notification.getMessage() + " (c) Company name");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        consumers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notification = notificationChanger.apply(notification);
        if (predicate.test(notification)) {
            throw new IllegalArgumentException("This message contains bad words");
        }

        consumers.get(notification.getType()).accept(notification);
    }
}
