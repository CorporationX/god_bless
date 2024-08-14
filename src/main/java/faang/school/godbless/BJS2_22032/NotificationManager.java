package faang.school.godbless.BJS2_22032;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class NotificationManager {
    private Map<String, Consumer<Notification>> handlers = new HashMap<>(
            Map.of(
                    "INFO", n -> System.out.println("INFO: " + n.getMessage()),
                    "WARNING", n -> System.out.println("WARNING: " + n.getMessage()),
                    "ERROR", n -> System.out.println("ERROR: " + n.getMessage()),
                    "NEW_MESSAGE", n -> System.out.println("DEBUG: " + n.getMessage()),
                    "SYSTEM_UPDATE", n -> System.out.println("DEBUG: " + n.getMessage()),
                    "CALENDAR_EVENT", n -> System.out.println("DEBUG: " + n.getMessage())
            )
    );

    public void registerHandler(String notificationType, Consumer<Notification> handler) {
        handlers.put(notificationType, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null)
            handler.accept(notification);
        else
            System.out.println("No handler registered for " + notification.getType());
    }
}
