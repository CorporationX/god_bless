package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notification, Consumer<Notification> handler) {
        notifications.put(notification, handler);
    }

    public void sendNotification(Notification notification) {
        if (notifications.get(notification.getType()) == null ) {
            System.out.println("Sorry, we were unable to handle this notification");
        } else {
            notifications.get(notification.getType()).accept(notification);
        }
    }
}
