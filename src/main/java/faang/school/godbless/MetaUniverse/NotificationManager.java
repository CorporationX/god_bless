package faang.school.godbless.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> directionAndMessage = new HashMap<>();

    public void registerHandler(String message, Consumer<Notification> consumer) {
        directionAndMessage.put(message, consumer);
    }

    public void sendNotification(Notification notification) {
        if (directionAndMessage.containsKey(notification.type())) {
            directionAndMessage.get(notification.type()).accept(notification);
        } else {
            System.out.println("There is no " + notification);
        }
    }
}