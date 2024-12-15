package school.faang.sprint_2.task_43535;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> registeredNotifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        registeredNotifications.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Optional.ofNullable(registeredNotifications.get(notification.type())).ifPresentOrElse(
                handler -> handler.accept(notification),
                () -> System.out.println("Обработчика для такого типа оповещения нет")
        );
    }
}

