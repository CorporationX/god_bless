package faang.school.godbless.sendingFbNotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            completableFutures.add(notificationManager.fetchNotification());
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).thenRun(() -> {
            List<Notification> notifications = notificationManager.getNotifications();
            System.out.println("Список уведомлений:");
            for (Notification notification : notifications) {
                System.out.println(notification.getId() + ": " + notification.getMessage());
            }
        }).join();
    }
}
