package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer<Notification>> notificationHandler = new HashMap<>();

    protected void registerHandler(String type, Consumer<Notification> consumer) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type can't be empty");
        }

        notificationHandler.put(type, consumer);
    }

    protected void sendNotification(Notification notification) {

        if (notificationHandler.entrySet().stream().noneMatch(n -> n.getKey().equals(notification.getType()))) {
            System.out.println("Обработчик для типа оповещения " + notification.getType() + " не найден.");
        } else {
            Consumer<Notification> handler = notificationHandler.get(notification.getType());
            handler.accept(notification);
        }
    }
}
