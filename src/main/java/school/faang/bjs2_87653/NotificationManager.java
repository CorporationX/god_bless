package school.faang.bjs2_87653;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notificationHandlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notificationHandlers.put(type, handler);
    }

    public void sendNotification(Notification note) {
        if (notificationHandlers.containsKey(note.getType())) {
            notificationHandlers.get(note.getType()).accept(note);
            return;
        }
        System.out.println("Invalid notification.");
    }
}