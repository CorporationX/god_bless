package school.faang.sprint2.bjs_46805;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


public class NotificationManager {
    public Map<String, Consumer<Notification>> handlersData = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlersData.put(type, handler);
    }

    public Consumer<Notification> sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = handlersData.get(type);

        if (handler == null) {
            throw new NoSuchElementException("Ошибка");
        }

        return handler;
    }
}
