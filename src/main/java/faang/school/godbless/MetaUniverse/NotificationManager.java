package faang.school.godbless.MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer){
        map.put(type, consumer);
    }

    public void sendNotification(Notification notification){
        Consumer<Notification> consumer = map.get(notification.getType());
        if(consumer != null){
            consumer.accept(notification);
        }else {
            System.out.println("Consumer not found :{ ");
        }
    }
}
