package school.faang.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> registredTypes = new HashMap<>();

    public void sendNotification (Notification notification){
        if (registredTypes.containsKey(notification.getType())){
            registredTypes.get(notification.getType()).accept(notification);
        }
    }

    public void registerHandler(String type, Consumer<Notification> notificationMessage){
        registredTypes.put(type, notificationMessage);
    }


}
