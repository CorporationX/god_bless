package school.faang.BJS238853;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NotificationManager {
    private final List<Notification> notificationList = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
               log.error("Проблема с добавлением уведомления {}", e.getMessage());
            }
            Notification notification = new Notification(id, message);
            addNotification(notification);
        });
    }

    public void printNotifications() {
        notificationList.forEach(notification ->
                System.out.println("ID: " + notification.getId() + ", Message: " + notification.getMessage())
        );
    }
}
