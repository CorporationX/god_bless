package school.faang.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String typeNotification, Consumer<Notification> handler) {
        handlers.put(typeNotification, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> typeNotification = handlers.get(notification.getType());
        if (typeNotification != null) {
            typeNotification.accept(notification);
        } else {
            System.out.println("Такого обработчика неть :(");
        }
    }
}
