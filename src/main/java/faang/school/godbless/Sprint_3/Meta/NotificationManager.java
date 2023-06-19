package faang.school.godbless.Sprint_3.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public static Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String indicator, Consumer<Notification> consumer) {
        map.put(indicator, consumer);
    }
    public void sendNotification(Notification notification) {
        map.get(notification.getType()).accept(notification);
    }
}