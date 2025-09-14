package school.faang.bjs2_87612_metaverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.getOrDefault(
                notification.getNotificationType(),
                (n) -> System.out.println("Обработчик для типа " + n.getNotificationType() + " не найден")
        );

        handler.accept(notification);
    }
}