package faang.school.godbless.facebooknotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotificationManager {

    private final List<Notification> notifications = new ArrayList<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final Object lock = new Object();

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addNotification(Notification notification) {
        synchronized (lock) {
            notifications.add(notification);
        }
    }

    public CompletableFuture<Void> fetchNotification(Long id) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            addNotification(new Notification("New message"));
        }, executorService);
    }

    public void shutdownAndAwaitExecution(int minutes) {
        executorService.shutdown();
        awaitTermination(minutes);
    }

    private void awaitTermination(int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
