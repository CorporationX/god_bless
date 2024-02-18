package faang.school.godbless.metaUniverse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;



public class NotificationManager {

    private final Map<String, Consumer<Notification>> mapNotification = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notificationHandler) {
        mapNotification.put(type, notificationHandler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationConsumer = mapNotification.get(notification.getType());
        notificationConsumer.accept(notification);
    }
}
