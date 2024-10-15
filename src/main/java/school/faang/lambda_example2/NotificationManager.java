package school.faang.lambda_example2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlersByNotificationId = new HashMap<>();


    public void registerHandler(String notificationId, Consumer<Notification> notification) {
        handlersByNotificationId.putIfAbsent(notificationId, notification);
    }

    public void sendNotification(Notification notificationName) {
        Consumer<Notification> handler = handlersByNotificationId.get(notificationName.getType());
        if (handler != null) {
            handler.accept(notificationName);
        }
        System.out.println(notificationName.getMessage());
    }
}
