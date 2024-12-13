package school.faang.sprint_2.task_46826;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationStash = new HashMap<>();

    public void registerHandler(String typeNotification,
                                Consumer<Notification> notificationConsumer) {
        notificationStash.put(typeNotification, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> value = notificationStash.get(notification.getType());
        value.accept(notification);
    }
}
