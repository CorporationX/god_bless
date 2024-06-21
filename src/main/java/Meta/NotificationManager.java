package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> mapNotification = new HashMap<>();

    public void registerHandler(String notificationId , Consumer<Notification> consumer) {
        mapNotification.put(notificationId , consumer);
    }

    public void sendNotification(Notification notification) {
        if (mapNotification.containsKey(notification.getType()))
            mapNotification.get(notification.getType()).accept(notification);
        else
            throw new NullPointerException("There is no such notification in the map");
    }

    public void check(Notification notification) {
        Predicate<String> predicate = x -> x.equals("sms");
        if (predicate.test(notification.getType()))
            sendNotification(notification);
    }
}
