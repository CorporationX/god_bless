package faang.school.godbless.forbidden.meta;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private static final Logger logger = LoggerFactory.getLogger(NotificationManager.class);
    private final Map<String, Consumer<Notification>> typeHandlerMap = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        typeHandlerMap.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = typeHandlerMap.get(notification.getType());
        if (notificationConsumer == null) {
            logger.warn(String.format("Unknown notification type: %s, message: %s. Need to add a handler",
                    notification.getType(), notification.getMessage()));
            Consumer<Notification> defaultNotificationConsumer =
                    acceptedNotification -> System.out.printf("Type of notification: %s, message: %s",
                            acceptedNotification.getType(), acceptedNotification.getMessage());
            defaultNotificationConsumer.accept(notification);
        } else {
            notificationConsumer.accept(notification);
        }
    }
}
