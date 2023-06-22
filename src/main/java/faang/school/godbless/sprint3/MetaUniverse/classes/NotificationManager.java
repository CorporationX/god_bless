package faang.school.godbless.sprint3.MetaUniverse.classes;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    public static final String NOTIFICATION_IS_NULL_MESSAGE = "Notification is null";
    private final Map<String, Consumer<Notification>> notificationMap;

    public NotificationManager(){
        notificationMap = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> consumer){
        notificationMap.put(type, consumer);
    }

    public void sendNotification(Notification notification){
        if (Notification.isNull(notification)){
            throw  new IllegalArgumentException(NOTIFICATION_IS_NULL_MESSAGE);
        }
        notificationMap.get(notification.getType()).accept(notification);
    }
}
