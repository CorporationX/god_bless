package faang.school.godbless.Meta;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    private Map<String, Consumer> map = new HashMap<>();

    public void registerHandler(String str, Consumer consumer) {
        map.put(str, consumer);
    }

    public void sendNotification(Notification notification) {
        map.get(notification.getType()).act(notification);
    }
}
