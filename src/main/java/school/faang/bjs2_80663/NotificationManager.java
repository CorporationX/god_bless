package school.faang.bjs2_80663;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> noticitationsMap = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        noticitationsMap.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        if (Objects.isNull(noticitationsMap.get(notification.getNotificationType()))) {
            System.out.println("Notification for this email isn't found");
            return;
        }
        noticitationsMap.get(notification.getNotificationType()).accept(notification);
    }
}
