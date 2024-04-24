package faang.school.godbless.bjs2_6018;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NotificationManager {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    private final List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        log.info("Add notification with ID {} to list", notification.getId());
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification(long id, String message) {
        var result = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                Notification notification = new Notification(id, message);
                addNotification(notification);
                return notification;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executor);
        result.thenRun(executor::shutdown);
        return result;
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
    }

}
