package faang.school.godbless.BJS2_748;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> actions = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationAction) {
        actions.put(notificationType, notificationAction);
    }

    public void sendNotification(Notification notification) {
        actions.getOrDefault(notification.getType(), (defaultNotificationAction ->
                        System.out.println("Action not found for notification type: " + notification.getType())))
                .accept(notification);
    }
}