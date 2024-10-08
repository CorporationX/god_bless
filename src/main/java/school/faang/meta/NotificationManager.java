package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    protected static final Map<String, Consumer<Notification>> notificationConsumer = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer){
        notificationConsumer.putIfAbsent(type, consumer);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> handler = notificationConsumer.get(notification.getType());

        if(handler != null){
            handler.accept(notification);
        }
    }
}
