package school.faang.BJS2_57838;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> notificationTypeConsumerMap = new HashMap<>();

    public  void registerHandler(NotificationType type, Consumer<Notification> handler) {

    }
    public void sendNotification(Notification notification) {

    }
}
