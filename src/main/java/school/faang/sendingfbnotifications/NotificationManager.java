package school.faang.sendingfbnotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class NotificationManager {

    private final List<Notification> notifications = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Поток был прерван во время выполнения задачи", e);
            }

            Notification notification = new Notification(id, message);

            addNotification(notification);
            System.out.println("Уведомление добавлено: " + notification.getMessage());
        }, executorService);
    }

    public void displayNotifications() {
        synchronized (this) {
            notifications.forEach(notification ->
                    System.out.println("ID: " + notification.getId() + ", Message: " + notification.getMessage())
            );
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
