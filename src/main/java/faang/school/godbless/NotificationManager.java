package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
@Setter
public class NotificationManager {
    private Map<String,Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler){
        notificationHandlers.put(type,handler);
    }
    public void sendNotification(Notification notification){
            Consumer<Notification> handler = notificationHandlers.get(notification.getType());
            handler.accept(notification);
    }
}
