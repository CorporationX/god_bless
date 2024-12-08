package school.faang.sprint_2.task_46602;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> idNotification = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> notification) {
        idNotification.put(type, notification);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();

        Consumer<Notification> consumer = idNotification.get(type);

        if (consumer == null) {
            consumer = notification1 -> System.out.println("Нет обработчика для данного типа: " + type);
        }
        consumer.accept(notification);
    }
}
