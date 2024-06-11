package faang.school.godbless;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    @NonNull
    public void registerHandler(
            String identifierNotification, Consumer<Notification> notificationConsumer) {
        notifications.put(identifierNotification, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.getType());
    }
}
