package faang.school.godbless.facebooknotifications3274;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class NotificationManager {
    private List<Notification> notifications;

    public CompletableFuture<Notification> fetchNotification(Notification notification, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            threadSleep();
            addNotification(notification);
            System.out.println("Notification #" + notification.getId() + " added");
            return notification;
        }, executor);
    }

    private synchronized void addNotification(Notification notification) {
        if (this.notifications == null) {
            notifications = new ArrayList<>();
        }
        notifications.add(notification);
    }

    private void threadSleep() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
