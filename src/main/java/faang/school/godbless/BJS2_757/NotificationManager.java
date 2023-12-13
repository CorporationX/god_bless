package faang.school.godbless.BJS2_757;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumerNotification){
        map.put(type, consumerNotification);
        }

    public void sendNotification(Notification notification){
        Consumer<Notification> consumer =  map.get(notification.getType());
        consumer.accept(notification);
    }
}
