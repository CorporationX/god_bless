package school.faang.sprint4.bjs_50575;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class NotificationManager {
    private static final int NOTIFICATION_DELAY = 5000;
    private static final String MESSAGE_OF_THREAD_INTERRUPTED = "Поток был прерван";

    private final List<Notification> notifications;

    public NotificationManager() {
        this.notifications = new ArrayList<>();
    }

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            log.info("Уведомление {} добавляется...", id);
            try {
                Thread.sleep(NOTIFICATION_DELAY);
            } catch (InterruptedException e) {
                log.info(MESSAGE_OF_THREAD_INTERRUPTED);
                Thread.currentThread().interrupt();
            }
            addNotification(new Notification(id, message));
            log.info("Уведомление {} добавлено", id);
        });
    }

    public void printNotifications() {
        for (Notification notification : notifications) {
            log.info("Уведомление {}: \"{}\"", notification.getId(), notification.getMessage());
        }
    }
}
