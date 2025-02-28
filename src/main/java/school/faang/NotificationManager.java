package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

@Slf4j
public class NotificationManager {
    private final Queue<Notification> notifications = new ConcurrentLinkedQueue<>();
    private static final int FETCHING_LATENCY_MS = 1000;

    private void addNotification(Notification notification) {
        notifications.add(notification);
        log.info("Message {} added to NotificationManager.", notification.getMessage());
    }

    public CompletableFuture<Void> fetchNotification(int id, String message, ExecutorService executor) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(FETCHING_LATENCY_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep was interrupted in \"fetchNotification\"");
            }
            addNotification(new Notification(id, message));
        }, executor);
    }
}
