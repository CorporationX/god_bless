package Task2;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Data
public class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer){
        if(!map.containsKey(type)){
            map.put(type, consumer);
        }
    }
    public void sendNotification(Notification notification){
        String type = notification.getType();
        Consumer<Notification> consumer = map.get(type);
        if(consumer != null){
            consumer.accept(notification);
        }
    }
}
