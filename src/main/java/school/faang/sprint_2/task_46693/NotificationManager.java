package school.faang.sprint_2.task_46693;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        if (notificationType == null || handler == null) {
            throw new IllegalArgumentException("Invalid params");
        }
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            throw new IllegalArgumentException("notification is null");
        }

        try {
            handlers.get(notification.type()).accept(notification);
        } catch (NullPointerException e) {
            throw new NoSuchElementException();
        }
    }
}
