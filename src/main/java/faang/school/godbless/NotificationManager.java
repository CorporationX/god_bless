package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap();

    public void registerHandler(String alerts, Consumer<Notification> consumer) {
        map.put(alerts, consumer);
    }

    public void sendNotification(Notification notification) {
        map.get(notification.getType()).accept(notification);
    }

    public void check(Notification notification) {
        Predicate<String> predicate = x -> x.equals("sms");
        if (predicate.test(notification.getType()))
            sendNotification(notification);
    }
}
