package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer<Notification>>  handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        handlers.put(type, consumer);
    }
    public void sendNotification(Notification notification){
        handlers.get(notification.getType()).accept(notification);
    }
}
