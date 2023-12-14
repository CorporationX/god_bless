package Lambda_2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String string, Consumer<Notification> consumer) {
        handlers.put(string, consumer);
    }

    public void sendNotification(Notification notification) {
        if (handlers.containsKey(notification))
            handlers.get(notification.getType()).accept(notification);
    }


}
