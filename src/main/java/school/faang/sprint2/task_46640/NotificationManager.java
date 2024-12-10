package school.faang.sprint2.task_46640;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationTypes = new HashMap<>();

    public void registerHandler(@NonNull NotificationType type, @NonNull Consumer<Notification> realization) {
        notificationTypes.put(type, realization);
        log.info("New notification logic for " + type + " was added");
    }

    public void sendNotification(@NonNull Notification notification) {
        Consumer<Notification> notificationRealization = notificationTypes.get(notification.getType());
        if (notificationRealization == null) {
            throw new IllegalArgumentException("There is no realization for this type of notification");
        }
        notificationRealization.accept(notification);
    }
}
