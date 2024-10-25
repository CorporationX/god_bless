package school.faang.sendnotificationsfacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
        System.out.println("Notification added: " + notification.getMessage());
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);

                Notification notification = new Notification(id, message);
                addNotification(notification);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
    }

    public void printNotifications() {
        System.out.println("All Notifications:");
        notifications.forEach(notification ->
                System.out.println("ID: " + notification.getId() + ", Message: " + notification.getMessage()));
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
