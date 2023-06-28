import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
   private Map<String, Consumer<Notification>> notificationHandlersMap = new HashMap<>();

    public void registerHandler(String alertType, Consumer<Notification> notificationConsumer) {
        notificationHandlersMap.put(alertType, notificationConsumer);
    }
    public void sendNotification(Notification notification) {
        if (notificationHandlersMap.containsKey(notification.getType())) {
            notificationHandlersMap.get(notification.getType()).accept(notification);
        }

    }
}
