package bjs2_61828;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class NotificationManager {
    private static final int FETCH_WORK_TIME_MS = 1_000;

    private final List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        var notification = new Notification(id, message);

        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(FETCH_WORK_TIME_MS);
            } catch (InterruptedException e) {
                log.error("Ошибка в fetchNotification: {}", e.getMessage(), e);

                return;
            }

            addNotification(notification);
        });
    }

    public void printNotifications() {
        for (Notification notification : notifications) {
            log.info("{}: {}", notification.getId(), notification.getMessage());
        }
    }
}
