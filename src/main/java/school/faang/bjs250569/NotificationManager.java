package school.faang.bjs250569;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
public class NotificationManager {

    private static final int CREATION_TIME = 3000;
    private final List<Notification> notifications = new ArrayList<>();

    public CompletableFuture<Void> fetchNotification(int i, String message) {

        return CompletableFuture.runAsync(() -> {
            try {
                Notification notification = new Notification(i, message);
                Thread.sleep(CREATION_TIME);
                addNotification(notification);
                log.info("Notification with id {} has added", notification.id());

            } catch (InterruptedException e) {
                log.error("The tread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        });
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void printNotifications() {
        notifications.forEach(notification ->
                log.info("Notification with id {} has printed", notification.id()));
    }
}