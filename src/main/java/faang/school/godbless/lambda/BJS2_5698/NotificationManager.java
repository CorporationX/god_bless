package faang.school.godbless.lambda.BJS2_5698;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> action) {
        notifications.put(type, action);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notifications.get(notification.getType());

        if (consumer == null) {
            throw new IllegalArgumentException("Нотификация типа " + notification.getType() +" не зарегистрирована!");
        }
        consumer.accept(notification);
    }
}
