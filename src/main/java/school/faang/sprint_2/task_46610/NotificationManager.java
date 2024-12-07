package school.faang.sprint_2.task_46610;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    Map<String, Consumer<Notification>> typesConsumer = new HashMap<>();

    void registerHandler(String type, Consumer<Notification> notificationConsumer) {
        typesConsumer.put(type, notificationConsumer);
    }

    void sendNotification(Notification notification) {
        if (!typesConsumer.containsKey(notification.getType())) {
            throw new IllegalArgumentException("Идентификатор уведомления не найден");
        } else {
            typesConsumer.get(notification.getType()).accept(notification);
        }
    }
}
