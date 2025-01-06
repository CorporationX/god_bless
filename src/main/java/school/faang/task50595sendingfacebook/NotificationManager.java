package school.faang.task50595sendingfacebook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class NotificationManager {

    private static final int GREAT_TIME = 1000;
    private final List<Notification> notifications = new ArrayList<>();

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void printNotifications() {
        notifications.forEach(notification -> {
            log.info(" ID {} Message {} ", notification.getId(), notification.getMessage());
        });
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(GREAT_TIME);
                Notification notification = new Notification(id, message);
                addNotification(notification);
                log.info("Добавлено уведомление {} ", notification.getMessage());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        });

    }
}
