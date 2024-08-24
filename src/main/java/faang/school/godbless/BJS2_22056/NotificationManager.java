package faang.school.godbless.BJS2_22056;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<String, Consumer<Notification>> notificationCatalog = new HashMap<>();

    public static void registerHandler(String id, Consumer<Notification> consumer) {
        notificationCatalog.put(id, consumer);
    }

    public static void sendNotification(Notification notification) {
        Consumer<Notification> consumer = notificationCatalog.get(notification.getType());
        if (consumer != null) {
            consumer.accept(notification);
        } else {
            System.out.println("Не найден обработчик для типа: " + notification.getType());
        }
    }

}
