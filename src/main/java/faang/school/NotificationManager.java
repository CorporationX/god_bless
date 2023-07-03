package faang.school;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    List<Notification> notifications = new ArrayList<>();
    private int notificationId = 1;

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification() {
        return CompletableFuture.supplyAsync(() -> {
            Notification notification = new Notification(notificationId, "message number " + notificationId++);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addNotification(notification);
            return notification;
        });
    }
}

