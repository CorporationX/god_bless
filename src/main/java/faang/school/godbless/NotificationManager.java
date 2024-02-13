package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler(String notificationType, Consumer<Notification> message){
        map.put(notificationType, message);
    }
    public void sendNotification(Notification notification){
        String notificationType = notification.getType();
        Consumer<Notification> type = map.get(notificationType);
        if (type != null) {
            type.accept(notification);
        }
    }
}
