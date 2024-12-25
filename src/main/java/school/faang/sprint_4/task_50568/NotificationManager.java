package school.faang.sprint_4.task_50568;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class NotificationManager {
    private static final int FETCHING_DELAY = 1000;

    private final List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(FETCHING_DELAY);
                addNotification(new Notification(id, message));
            } catch (InterruptedException e) {
                log.info("Fetching notification interrupted");
                Thread.currentThread().interrupt();
            }
        });
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
    }
}
