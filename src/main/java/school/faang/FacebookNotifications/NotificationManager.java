package school.faang.FacebookNotifications;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class NotificationManager {
    private final List<Notification> notifications = Collections.synchronizedList(new ArrayList<>());

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
            }
            addNotification(new Notification(id, message));
            log.info("Notification #{} has been fetched", id);
        });
    }

    public void printNotifications() {
        notifications.forEach(System.out::println);
        log.info("Total notifications: {}", notifications.size());
    }

}
