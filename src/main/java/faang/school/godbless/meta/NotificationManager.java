package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications = new HashMap<>();
    public void registerHandler(String type,Consumer<Notification> handler){
        notifications.put(type,handler);
    }
    public void sendNotification(Notification notification) {
        String type = notification.getType();
        notifications.get(type).accept(notification);
    }
}
