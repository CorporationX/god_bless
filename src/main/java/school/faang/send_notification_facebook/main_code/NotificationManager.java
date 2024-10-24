package school.faang.send_notification_facebook.main_code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void fetchAllNotifications() {
        List<CompletableFuture<Notification>> notificationFutures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            notificationFutures.add(fetchNotification(i, "message_" + i));
        }

        CompletableFuture<Void> allNotificationFutures =
                CompletableFuture.allOf(notificationFutures.toArray(CompletableFuture[]::new))
                        .thenRun(() -> {
                            notifications.forEach(notification ->
                                    System.out.println(notification.getMessage()));
                        });

        allNotificationFutures.join();
    }

    private CompletableFuture<Notification> fetchNotification(int id, String message) {
        CompletableFuture<Notification> notificationFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Notification notification = new Notification(id, message);

            addNotification(notification);

            return notification;
        });
        return notificationFuture;
    }
}
