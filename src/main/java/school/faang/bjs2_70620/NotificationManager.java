package school.faang.bjs2_70620;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlersByType = new HashMap<>();
    private final Predicate<String> badWordsFilter = text -> text.toLowerCase().contains("ass");

    public Consumer<Notification> registerHandler(NotificationType type, Consumer<Notification> handler) {
        return notificationHandlersByType.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = Optional.ofNullable(notificationHandlersByType.get(
                notification.getNotificationType())).orElseThrow(() -> new NoSuchElementException(String.format(
                "Handler for notification with type %s not found", notification.getNotificationType())));
        if (!badWordsFilter.test(notification.getMessage())) {
            handler.accept(notification);
        } else {
            System.out.printf("Your message contains bad words. We don't able to send it.");
        }
    }
}