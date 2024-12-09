package school.faang.task_46661;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static Map<String, Consumer<Notification>> messageStorage = new HashMap<>();

    public void registerHandler(String alertIdentifier, Consumer<Notification> message) {
        messageStorage.put(alertIdentifier, message);
    }

    public void sendNotification(Notification notification) {
        if (messageStorage.containsKey(notification.getType())) {
            messageStorage.get(notification.getType()).accept(notification);
        } else {
            System.out.println("Данный тип оповещений отсутсвует!");
        }
    }
}
