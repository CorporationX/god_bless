package faang.school.godbless.notifications_Facebook;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Getter
public class NotificationManager {
    private final List<Notification> notifications;

    public NotificationManager() {
        this.notifications = new ArrayList<>();
    }

    public synchronized void addNotification(Notification notification) {
        System.out.println("Adding notification: " + notification.getId());
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotifications() {
        return CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Fetching notifications...");
                Thread.sleep(Math.round(Math.random() * 10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addNotification(new Notification(getID(), "Notification from Facebook"));
        });
    }

    private String getID() {
        return UUID.randomUUID().toString();
    }
}
