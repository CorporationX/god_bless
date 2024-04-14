package faang.school.godbless.BJS2_5400;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> action) {
        NOTIFICATIONS.put(type, action);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> consumer = NOTIFICATIONS.get(notification.getType());

        if (consumer == null) {
            throw new IllegalArgumentException("Нотификации типа " + notification.getType() +" не зарегистрирована!");
        }

        consumer.accept(notification);
    }
}
