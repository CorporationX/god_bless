package school.faang.task_46729;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {

    private Map<String, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для такого типа оповещений: " + notification.getType());
        }

    }
}
