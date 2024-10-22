package school.faang.notifyinfacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int TIME_TO_WORK = 1000;

    private List<Notification> notifications = new ArrayList<>();
    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(TIME_TO_WORK);
                    addNotification(new Notification(id, message));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
