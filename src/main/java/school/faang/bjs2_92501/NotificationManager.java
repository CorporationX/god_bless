package school.faang.bjs2_92501;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    synchronized void addNotification(Notification notification) {
        if (notification == null) {
            log.error("Notifications cannot be null");
            throw new IllegalArgumentException("Notifications cannot be null");
        }
        notifications.add(notification);
        System.out.printf("Notification added: %s%n", notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Notification notification = new Notification(id, message);
                addNotification(notification);
            } catch (Exception e) {
                log.error("Error processing notification");
                throw new RuntimeException("Error processing notification");
            }
        });
    }

    public void printNotifications() {
        System.out.println("Print all notifications: ");
        notifications.forEach(System.out::println);
    }
}
