package BJS2_10145;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer> mailing = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notify) {
        mailing.put(type, notify);
    }
    public void sendNotification(Notification notification) {
        Consumer consumer = mailing.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        }

    }
}
