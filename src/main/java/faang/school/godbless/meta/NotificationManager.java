package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> notifications;

    public NotificationManager() {
        this.notifications = new HashMap<>();
    }

    public void registerHandler(String notificationID, Consumer<Notification> consumer) {
        notifications.put(notificationID, consumer);
    }

    public void sendNotification(Notification notification) {
        try {
            notifications.get(notification.getType()).accept(notification);
        } catch(NullPointerException e){
            System.out.println(e);
        }
    }
}
