package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotifManager {
    private Map<NotifType, Consumer<Notification>> handlers = new HashMap<>();

    public void addHandler(NotifType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void send(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.type);

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Ошибка : нет обработчика для " + notification.type);
        }

    }
}
