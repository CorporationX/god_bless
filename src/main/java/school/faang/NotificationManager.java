package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();
    private static final int FETCHING_LATENCY_MS = 1000;

    private synchronized void addNotification(Notification notification) {
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
