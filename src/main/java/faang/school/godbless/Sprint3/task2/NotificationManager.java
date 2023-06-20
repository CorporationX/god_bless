package faang.school.godbless.Sprint3.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String identifier, Consumer<Notification> notificationConsumer) {
        notifications.put(identifier, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        if (!(notifications.containsKey(notification.getType()))){
            throw new IllegalArgumentException("Message");
        }
        notifications.get(notification.getType()).accept(notification);
//        if (notifications.containsKey(notification.getType())) {
//            notifications.get(notification.getType()).accept(notification);
//        } else {
//            System.out.println("Message");
//        }
    }

}
