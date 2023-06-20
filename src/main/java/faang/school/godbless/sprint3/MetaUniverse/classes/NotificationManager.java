package faang.school.godbless.sprint3.MetaUniverse.classes;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private final Map<String, Consumer<Notification>> notificationMap;

    public NotificationManager(){
        notificationMap = new HashMap<>();
    }

    public void registerHandler(String type, Consumer<Notification> consumer){
        notificationMap.put(type, consumer);
    }

    public void sendNotification(Notification notification){
        notificationMap.get(notification.getType()).accept(notification);
    }
}
