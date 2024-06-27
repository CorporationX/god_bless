package faang.school.godbless.facebook_notifications;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class NotificationManager {
    private final ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final long NOTIFICATION_FETCHING_TIME = 1000L;
    private final List<Notification> notificationList = new ArrayList<>();

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(NOTIFICATION_FETCHING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException("Could not fetch notification: " + e.getMessage());
            }

            Notification notification = new Notification(id, message);
            addNotification(notification);
        }, executorService);
    }

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    public void closeNotificationManager() {
        executorService.shutdown();
    }
}
