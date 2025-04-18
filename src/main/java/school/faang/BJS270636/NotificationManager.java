package school.faang.BJS270636;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    //карта для хранения обработчиков оповещений
    private Map<Notification.NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(Notification.NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        //получаем обработчик для данного типа оповещений
        Consumer<Notification> handler = handlers.get(notification.getType());

        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Обработчи не найден");
        }

    }
}
