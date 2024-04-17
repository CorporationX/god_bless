package faang.school.godbless.BJS2_5613;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> consumer) {
        notifications.put(type, consumer);
    }
    public void sendNotification(Notification notification) {
        notifications.get(notification.getType()).accept(notification);
    }
}
