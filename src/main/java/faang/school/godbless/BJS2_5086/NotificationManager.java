package faang.school.godbless.BJS2_5086;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler){
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification){
        if (!handlers.containsKey(notification.getType())) {
            throw new NoSuchElementException("Не удалось найти данный тип обработчика: " + notification.getType());
        }
        handlers.get(notification.getType()).accept(notification);
    }
}
