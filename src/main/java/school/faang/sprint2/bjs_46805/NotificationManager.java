package school.faang.sprint2.bjs_46805;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


public class NotificationManager {
    public Map<NotificationType, Consumer<Notification>> handlersData = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (handler == null) {
            throw new NullPointerException("Передаваемое значение не может быть null");
        }

        handlersData.put(type, handler);
    }

    public Consumer<Notification> sendNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("Передаваемое значение не может быть null");
        }

        NotificationType type = notification.getType();
        Consumer<Notification> handler = handlersData.get(type);

        if (handler == null) {
            throw new NoSuchElementException("Ошибка");
        }

        return handler;
    }
}
