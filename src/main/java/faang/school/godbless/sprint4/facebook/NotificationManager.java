package faang.school.godbless.sprint4.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    List<Notification> notifications = new ArrayList<>();
    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id,String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                Notification newNotification = new Notification(id, message);
                addNotification(newNotification);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
