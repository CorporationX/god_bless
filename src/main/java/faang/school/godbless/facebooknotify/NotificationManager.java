package faang.school.godbless.facebooknotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotificationManager {

    private final List<Notification> NOTIFICATIONS = new ArrayList<>();
    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public List<Notification> getNotifications() {
        return NOTIFICATIONS;
    }

    public void addNotification(Notification notification) {
        synchronized (NOTIFICATIONS) {
            NOTIFICATIONS.add(notification);
        }
    }

    public CompletableFuture<Void> fetchNotification() {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            addNotification(new Notification("New message"));
        }, EXECUTOR_SERVICE);
    }

    public void shutdownAndAwaitExecution(int minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(minutes);
    }

    private void awaitTermination(int minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
