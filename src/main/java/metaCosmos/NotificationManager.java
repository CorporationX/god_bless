package metaCosmos;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String typeNotification, Consumer<Notification> consumer) {
        NOTIFICATIONS.put(typeNotification, consumer);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("Уведомление не может быть пустым!");
        }
        NOTIFICATIONS.get(notification.getType()).accept(notification);
    }

}
