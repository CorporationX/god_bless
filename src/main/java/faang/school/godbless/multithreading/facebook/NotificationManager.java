package faang.school.godbless.multithreading.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private final List<Notification> notifications;

    public NotificationManager() {
        notifications = new ArrayList<>();
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public synchronized CompletableFuture<Notification> fetchNotification() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        return CompletableFuture.supplyAsync(() -> {
            Notification notification = new Notification(
                    notifications.size() + 1,
                    "Notification-" + (notifications.size() + 1)
            );
            notifications.add(notification);
            return notification;
        });
    }
}
