package school.faang.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<NotificationType, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {

    }

    public void sendNotification(Notification notification) {

    }

}
