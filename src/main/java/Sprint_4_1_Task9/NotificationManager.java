package Sprint_4_1_Task9;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class NotificationManager {
    List<Notification> notifications = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public CompletableFuture<Notification> fetchNotification(Notification notification) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                addNotification(notification);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return notification;
        });
    }

    public static void main(String[] args) {
        Notification notification = new Notification(1, "Hello");
        Notification notification2 = new Notification(2, "Inna");
        Notification notification3 = new Notification(3, "!");

        NotificationManager notificationManager = new NotificationManager();

        CompletableFuture<Notification> future1 = notificationManager.fetchNotification(notification);
        CompletableFuture<Notification> future2 = notificationManager.fetchNotification(notification2);
        CompletableFuture<Notification> future3 = notificationManager.fetchNotification(notification3);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2, future3);
        voidCompletableFuture.thenAccept(v -> {
            notificationManager.getNotifications().forEach(System.out::println);
        }).join();


    }
}
