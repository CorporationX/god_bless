package school.faang.bjs2x46888;



import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer){
        notifications.put(type, consumer);
        log.info("The type has been added .");
    }
    public void sendNotification(Notification notification){
        Consumer<Notification> typeNotification = notifications.get(notification.getType());
        typeNotification.accept(notification);
        log.info("The notification has been send .");
    }

}
