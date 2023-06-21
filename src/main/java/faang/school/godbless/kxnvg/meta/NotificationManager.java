package faang.school.godbless.kxnvg.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private static final Map<String, Consumer<Notification>> NOTIFICATIONS = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        NOTIFICATIONS.put(type, consumer);
    }

    public void sendNotification(Notification notification) {
        if (NOTIFICATIONS.containsKey(notification.getType())) {
            NOTIFICATIONS.get(notification.getType()).accept(notification);
        } else {
            throw new NullPointerException("Такой идентификатор не зарегестрирован");
        }
    }
}
