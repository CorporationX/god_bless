package school.faang.sendnotificationsfacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>(); // Список для хранения всех уведомлений

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
        System.out.println("Notification added: " + notification.getMessage());
    }
}
