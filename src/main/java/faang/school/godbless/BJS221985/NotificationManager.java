package faang.school.godbless.BJS221985;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public Map<String, Consumer<Notification>> collectedNotifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        collectedNotifications.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> handler = collectedNotifications.get(notification.getType());
        handler.accept(notification);
    }
}
