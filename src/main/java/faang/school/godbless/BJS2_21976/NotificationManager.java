package faang.school.godbless.BJS2_21976;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationsIdx = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        notificationsIdx.putIfAbsent(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = notificationsIdx.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        }
    }
}
