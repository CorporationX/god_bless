package school.faangSprint4.t13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                Notification notification = new Notification(id, message);
                addNotification(notification);
                System.out.println("Added notification: " + notification.message());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void printNotifications() {
        notifications.forEach(notification ->
                System.out.println("ID: " + notification.id() + ", Message: " + notification.message()));
    }
}