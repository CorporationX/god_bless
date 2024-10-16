import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationTypes = new HashMap<>();



    public void registerHandler(String type, Consumer<Notification> action) {
        notificationTypes.put(type, action);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> result = notificationTypes.get(notification.getType());
        if (result == null) {
            System.out.println(notification.getType() + " - such type has not registered!");
        } else {
            result.accept(notification);
        }

    }
}

