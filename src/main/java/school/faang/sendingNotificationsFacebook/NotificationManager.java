package school.faang.sendingNotificationsFacebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private final List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Void> fetchNotification() {
        Random random = new Random();
        int randomId = random.nextInt(0, 1000);
        Notification notification = new Notification(randomId, "Message: " + randomId);
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3_000);
                addNotification(notification);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenRun(() -> System.out.println(notification.getId() + " is fetched."));
    }
}
