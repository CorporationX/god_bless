package task6;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> consumer){
        map.put(type, consumer);
    }
    public void sendNotification(Notification notification){
        String notificationId = notification.getType();
        map.get(notificationId).accept(notification);
    }
}
