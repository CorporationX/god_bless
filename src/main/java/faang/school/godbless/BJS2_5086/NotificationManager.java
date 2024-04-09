package faang.school.godbless.BJS2_5086;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationMap = new HashMap<>();

    public void registerHandler(String typeMessage, Consumer<Notification> notificationConsumer){
        notificationMap.put(typeMessage, notificationConsumer);
    }

    public void sendNotification(Notification notification){
        notificationMap.get(notification.getType()).accept(notification);
    }
}
