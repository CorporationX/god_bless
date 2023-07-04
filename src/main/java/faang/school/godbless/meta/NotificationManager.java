import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> mapNotification = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notificationConsumer){
        mapNotification.put(type, notificationConsumer);
    }
    public void sendNotification(Notification notification){
        Consumer<Notification> notificationConsumer = mapNotification.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
