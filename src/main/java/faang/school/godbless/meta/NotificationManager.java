package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationPull = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> alertID) {
        notificationPull.put(type, alertID);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> hendler = notificationPull.get(notification.getType());
        if (hendler != null)
            hendler.accept(notification);
        else throw new NoSuchElementException("This notification was not found");
    }
}
