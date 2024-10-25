package school.faang.BJS2_38822_FacebookNotifications;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NotificationManager {
    private static final int MIN_FETCHING_TIME = 3_000;
    private static final int MAX_FETCHING_TIME = 7_000;

    private List<Notification> notifications;

    public NotificationManager() {
        notifications = new ArrayList<>();
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            Notification notification = new Notification(id, message);
            log.info("Starting to fetch notification with id {}...", id);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_FETCHING_TIME, MAX_FETCHING_TIME));
            } catch (InterruptedException e) {
                log.error(
                        "Thread {} was interrupted while notification with id {} delivery!",
                        Thread.currentThread().getName(), id, e
                );
            }
            addNotification(notification);
            log.info("Fetching notification with id {} has ended...", id);
        });
    }

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }
}
