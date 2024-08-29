package facebook.notifications;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    private synchronized void addNotification(@NonNull Notification notification) {
        notifications.add(notification);
        log.info("Notification added");
    }

    public CompletableFuture<Void> fetchNotification() {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(3) * 500L + 500L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            addNotification(new Notification("aboba"));
        });
    }

    public void printAllNotifications() {
        notifications.forEach(n -> log.info(n.toString()));
    }
}
