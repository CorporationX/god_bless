package sendNotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class NotificationManager {
    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();
    private final List<Notification> notifications = new ArrayList<>();

    void addNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("Notif must be exits");
        }
        synchronized (this) {
            notifications.add(notification);
        }
    }

    public CompletableFuture<Void> fetchNotification(String nameNotification) {
        return CompletableFuture.runAsync(() -> {
            addNotification(new Notification(nameNotification));
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, SERVICE);
    }

    public void shutdown() {
        SERVICE.shutdown();
    }

    public List<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }
}
