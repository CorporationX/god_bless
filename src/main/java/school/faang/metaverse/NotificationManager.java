package school.faang.metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler){
        map.put(type,handler);
    }

    public void sendNotification(Notification notification){
        System.out.println(notification.getType());
        System.out.println(notification.getMessage());
    }
}
