package BJS2_2708;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Notification notification = new Notification("", "");
    Consumer<Notification> consumer = (Consumer<Notification>) notification -> System.out.println(" " + notification.getMessage());
    Map<String, Consumer<Notification>> map = new HashMap<String, Consumer<Notification>>();

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        map.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        map.get(notification);
    }
}
