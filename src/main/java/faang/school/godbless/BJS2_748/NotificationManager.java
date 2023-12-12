package faang.school.godbless.BJS2_748;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> registerHandler = new HashMap<>();
    private final Map<String, Function<Notification, Notification>> censoredHandler = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationAction) {
        registerHandler.put(notificationType, notificationAction);
    }

    public void censoredHandler(List<String> badWords, Function<Notification, Notification> censorAction) {
        badWords.forEach(badWord -> censoredHandler.put(badWord, censorAction));
    }

    public void sendNotification(Notification notification) {
        censoredHandler.forEach((key, value) -> {
            boolean isBadWord = notification.getMessage().contains(key);
            if (isBadWord) {
                value.apply(notification);
            }
        });

        registerHandler.getOrDefault(notification.getType(), (defaultNotificationAction ->
                        System.out.println("Action not found for notification type: " + notification.getType())))
                .accept(notification);
    }
}