package school.faang.bjs2_87681;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public final Map<NotificationType, Consumer<Notification>> notificationTypeConsumer = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {

    }

    public void sendNotification(Notification notification) {

    }
}
