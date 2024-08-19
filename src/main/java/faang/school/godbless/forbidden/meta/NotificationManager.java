package faang.school.godbless.forbidden.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<String, Consumer<Notification>> typeHandlerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        typeHandlerMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = typeHandlerMap.get(notification.getType());
        if (notificationConsumer == null) {
            Consumer<Notification> defaultNotificationConsumer =
                    acceptedNotification -> System.out.printf("Type of notification: %s, message: %s",
                            acceptedNotification.getType(), acceptedNotification.getMessage());
            defaultNotificationConsumer.accept(notification);
        } else {
            notificationConsumer.accept(notification);
        }
    }
}
