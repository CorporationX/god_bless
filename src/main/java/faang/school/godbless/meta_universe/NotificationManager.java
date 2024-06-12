package faang.school.godbless.meta_universe;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager/*Map<String, Consumer<Notification>> notifications*/ {

   private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> notificationConsumer) {
        notifications.put(notificationType, notificationConsumer);
    }

    public void sendNotification(Notification notification,
                                 Consumer<Notification> notificationConsumer) {

    }
}
