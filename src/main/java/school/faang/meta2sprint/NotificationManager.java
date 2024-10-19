package school.faang.meta2sprint;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        map.put(type, consumer);
    }

    public void sendNotification(Notification notificationObject) {
        for (Map.Entry<String, Consumer<Notification>> entryPair : map.entrySet()) {
            if (notificationObject.getType().equals(entryPair.getKey())) {
                System.out.println(entryPair.toString());
            }
        }
    }
}
