package meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notificationIdsOfHandlers = new HashMap<String, Consumer<Notification>>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        notificationIdsOfHandlers.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        Consumer consumer = notificationIdsOfHandlers.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.println("Опопвещение с типом " + notification.getType() + " не найдено");
        }
    }
}
