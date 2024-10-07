package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager  {

   Map<String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler(String text, Consumer<Notification> handler) {
        map.put(text, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = map.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа оповещения: " + notification.getType());
        }
    }
}
