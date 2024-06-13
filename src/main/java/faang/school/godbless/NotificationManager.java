package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();

    protected void registerHandler(String type, Consumer<Notification> consumer) {
        notificationHandler.put(type, consumer);
    }

    protected void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationHandler.get(notification.getType());

        if (handler != null){
            handler.accept(notification);
        }
    }
}
