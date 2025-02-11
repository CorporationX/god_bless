package school.faang.sprint2.lambda.metauniversal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        notificationMap.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        NotificationType notificationType = notification.getNotificationType();
        notificationMap.get(notificationType).accept(notification);
    }
}
