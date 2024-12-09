package school.faang.task_46568;

import school.faang.task_46568.model.Notification;
import school.faang.task_46568.model.NotificationType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> notificationConsumer) {
        notificationHandlers.put(type, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notificationHandlers.computeIfPresent(
                notification.getType(),
                (notificationType, notificationConsumer) -> {
                    notificationConsumer.accept(notification);
                    return notificationConsumer;
                }
        );
    }
}
