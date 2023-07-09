package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationService {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Void>> notificationFutures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CompletableFuture<Void> notificationFuture = notificationManager.fetchNotification();
            notificationFutures.add(notificationFuture);
        }

        CompletableFuture<Void> allNotificationsFuture = CompletableFuture.allOf(
                notificationFutures.toArray(new CompletableFuture[0]));

        allNotificationsFuture.thenRun(() -> {
            System.out.println("Notifications:");
            for (Notification notification : notificationManager.getNotifications()) {
                System.out.println("ID: " + notification.getId() + ", Message: " + notification.getMessage());
            }
        }).join();
    }
}
