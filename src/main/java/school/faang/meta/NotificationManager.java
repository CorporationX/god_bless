package school.faang.meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final List<String> badwordsList = List.of("badword1", "badword2", "badword3");
    private final Map<NotificationType, Consumer<Notification>> handler = new HashMap<>();
    private final Predicate<Notification> predicate = notification -> badwordsList.stream().anyMatch(
                    badword -> notification.getMessage().contains(badword));
    private final Function<Notification, Notification> notificationChanger = notification
            -> new Notification(notification.getType(), notification.getMessage() + " (c) Company name");

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        this.handler.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        notification = notificationChanger.apply(notification);
        if (!handler.containsKey(notification.getType())) {
            throw new IllegalArgumentException("There is no such type of notification");
        }

        if (predicate.test(notification)) {
            throw new IllegalArgumentException("This message contains bad words");
        }
        handler.get(notification.getType()).accept(notification);
    }
}
