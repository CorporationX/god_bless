package faang.school.godbless.BJS2_2984;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        map.put(type, consumer);
    }

    public void sendNotification(Notification notification){
        map.get(notification.getType()).accept(notification);
    }

}

