package metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static Map<String, Consumer<Notification>> notifications = new HashMap<>();

    void registerHandler(String identifier, Consumer<Notification> notification) {
        notifications.put(identifier, notification);
    }

    Consumer<Notification> sendNotification(Notification notification) {
        return notifications.get(notification.getType());
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notification = new Notification("Type", "Message");

        notificationManager.registerHandler("Test", notification1 -> System.out.println("fgfgfgf" + notification1.getMessage()));

    }
}
