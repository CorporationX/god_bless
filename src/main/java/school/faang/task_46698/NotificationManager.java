package school.faang.task_46698;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> consumerByNotificationType;

    public NotificationManager() {
        this.consumerByNotificationType = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        if (notificationType == null || notificationConsumer == null) {
            throw new NullPointerException("Notification type and consumer cannot be null");
        }

        if (!consumerByNotificationType.containsKey(notificationType)) {
            consumerByNotificationType.put(notificationType, notificationConsumer);
        } else {
            System.out.printf("Consumer for notification type already exists: %s%n", notificationType);
        }
    }

    public void sendNotification(Notification notification) {
        Objects.requireNonNull(notification, "Notification cannot be null");

        Consumer<Notification> notificationConsumer = consumerByNotificationType.get(notification.type());
        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            System.out.printf("No consumer found for notification : %s%n", notification);
        }
    }
}
