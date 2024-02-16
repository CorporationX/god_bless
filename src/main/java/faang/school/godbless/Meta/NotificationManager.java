package faang.school.godbless.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {

    private Map<String, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    //added check-up
    public void sendNotification(Notification notification) {
        if (notificationHandlers.containsKey(notification.getType())) {
            notificationHandlers.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Unsopperted notification type: " + notification.getType());
        }

    }

}