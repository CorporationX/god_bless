package sprint5.facebook;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    public CompletableFuture<Void> fetchNotification(String message) {
        pendingNotification();
        return CompletableFuture.runAsync(() -> addNotification(new Notification(notifications.size(), message)));
    }

    private synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    private void pendingNotification() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
