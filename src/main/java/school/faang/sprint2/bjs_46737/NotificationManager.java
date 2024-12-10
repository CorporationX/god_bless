package school.faang.sprint2.bjs_46737;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationClassifier = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        if (notificationType == null || handler == null) {
            System.out.println("Can't register such notification type");
        } else {
            notificationClassifier.put(notificationType, handler);
        }
    }

    public void sendNotification(Notification notification) {
        if (notification == null || !notificationClassifier.containsKey(notification.type())) {
            System.out.println("Unknown notification type");
        } else {
            notificationClassifier.get(notification.type()).accept(notification);
        }
    }
}
