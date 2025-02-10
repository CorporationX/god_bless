package task_BJS2_57697;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notifications = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {

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
    }
}
