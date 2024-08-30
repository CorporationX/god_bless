package faang.school.godbless.BJS2_24714;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class NotificationManager {

    private static final int NOTIFICATION_ADDED_TIME = 3;
    private final List<Notification> notifications;

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(Notification notification) {
        return CompletableFuture.runAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(NOTIFICATION_ADDED_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }

            addNotification(notification);
        });
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
    }
}
