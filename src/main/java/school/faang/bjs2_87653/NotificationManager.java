package school.faang.bjs2_87653;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> notification = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        notification.put(type, handler);
    }

    public void sendNotification(Notification note) {
        if (notification.containsKey(note.getType())) {
            notification.get(note.type).accept(note);
            return;
        }
        System.out.println("Invalid notification.");
    }
}