package faang.school.godbless.facebook;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
public class NotificationManager {
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        if (notification == null) {
            throw new NullPointerException("notification not found");
        }
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(int id, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                addNotification(new Notification(id, message));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
