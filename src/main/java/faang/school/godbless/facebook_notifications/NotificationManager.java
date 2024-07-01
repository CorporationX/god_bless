package faang.school.godbless.facebook_notifications;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class NotificationManager {
    private final long TIME_LIMIT_SECONDS = 5;
    private final long NOTIFICATION_FETCHING_TIME = 1000L;
    private final ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
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

        try {
            executorService.awaitTermination(TIME_LIMIT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
