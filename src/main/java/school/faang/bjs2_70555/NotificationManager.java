package school.faang.bjs2_70555;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    private final Map<NotificationType, NotificationHandler<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(NotificationType type, NotificationHandler<Notification> handlerRec) {
        this.notificationMap.put(type, handlerRec);
    }

    public void sendNotification(Notification notification) {
        NotificationHandler<Notification> handlerRec = this.notificationMap.get(notification.getType());
        if (handlerRec == null) {
            return;
        }
        if (!handlerRec.filter().test(notification)) {
            Notification tmpNotification = new Notification(notification.getType(),
                    handlerRec.signature().apply(notification));
            handlerRec.print().accept(tmpNotification);
        }
    }
}
