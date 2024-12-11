package school.faang.task_46698;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> consumerByNotificationType;

    public NotificationManager() {
        this.consumerByNotificationType = new HashMap<>();
    }

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> notificationConsumer) {
        if (!consumerByNotificationType.containsKey(type)) {
            consumerByNotificationType.put(type, notificationConsumer);
        } else {
            log.warn("Consumer for notification type already exists: {}", type);
        }
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> notificationConsumer = consumerByNotificationType.get(notification.type());
        if (notificationConsumer != null) {
            notificationConsumer.accept(notification);
        } else {
            log.warn("No consumer found for notification : {}", notification);
        }
    }

}
