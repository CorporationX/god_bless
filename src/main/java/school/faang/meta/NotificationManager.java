package school.faang.meta;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {

    private final Map<String, Consumer<Notification>> notificationConsumers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer){
        notificationConsumers.putIfAbsent(type, consumer);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> handler = notificationConsumers.get(notification.getType());

        if(handler != null){
            handler.accept(notification);
        }
    }
}
