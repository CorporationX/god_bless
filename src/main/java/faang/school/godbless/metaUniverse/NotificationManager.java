package faang.school.godbless.metaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();
    public  void registerHandler(String message, Consumer<Notification> consumer){
        notificationHandler.put(message, consumer);
    }

    void sendNotification(Notification notification) {
        notificationHandler.get(notification.getType()).accept(notification);
    }
}
