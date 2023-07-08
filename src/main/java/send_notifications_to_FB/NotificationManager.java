package send_notifications_to_FB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private List<Notification> notifications;

    public NotificationManager() {
        notifications = new ArrayList<>();
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            int id = new Random().nextInt(10000);
            Notification notification = new Notification(id, "New notification " + id);

            addNotification(notification);
            return notification;
        });
    }
}
