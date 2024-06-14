package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> managerNotification = new HashMap<>();

    public void registerHandler(String notificationID, Consumer<Notification> handler) {
        if(notificationID == null) {
            throw new IllegalArgumentException("ID notification not be null");
        }
        managerNotification.put(notificationID, handler);
    }

    public void sendNotification(Notification notification) {
        if(notification == null) {
            throw new IllegalArgumentException("Notification not be null");
        }
        var notificationType = notification.getType();
        if(managerNotification.containsKey(notificationType)) {
            managerNotification.get(notificationType).accept(notification);
        } else {
            throw new IllegalArgumentException("Not find notification in struct data");
        }
    }
}
