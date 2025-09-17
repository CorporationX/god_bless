package school.faang.meta;

import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<NotificationType, Consumer<Notification>> map;

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
    }

    public void sendNotification(Notification notification) {

    }

}
