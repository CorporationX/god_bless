package Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> messagesMap = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> consumer){
        if(!type.isEmpty()) {
            messagesMap.put(type, consumer);
        }
    }

    public void sendNotification( Notification notification){
        if(!notification.getType().isEmpty()) {
            messagesMap.get(notification.getType()).accept(notification);
        }

    }
}
