package faang.school.godbless.meta_universe;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
@ToString
public class NotificationManager {

   private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationType,
                                Consumer<Notification> notificationConsumer) {
        notifications.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification) {
        notifications.get(notification.type());
        System.out.println(notification);
    }
}
