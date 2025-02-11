package task_BJS2_57697;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Data
@Slf4j
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        try {
            switch (type) {
                case EMAIL -> {
                    handler.accept(new Notification(type, "просим подтвердить вашу почту!"));
                    notifications.put(type, handler);
                }
                case SMS -> {
                    handler.accept(new Notification(type, "сообщение с кодом уже у вас в смс"));
                    notifications.put(type, handler);
                }
                case PUSH -> {
                    handler.accept(new Notification(type, "получено новое сообщение"));
                    notifications.put(type, handler);
                }
                default -> throw new IllegalStateException("Unexpected value: " + type);
            }
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода registerHandler: ", exception);
        }
    }

    public void sendNotification(Notification notification) {
        try {
            registerHandler(notification.getType(), handler -> System.out.printf("%s\n", notification.getMessage()));
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода sendNotification: ", exception);
        }
    }

    public void addSignature(Notification notification, Function<Notification, Notification> function) {
        try {
            function.apply(notification);
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода sendNotification: ", exception);
        }
    }
}
