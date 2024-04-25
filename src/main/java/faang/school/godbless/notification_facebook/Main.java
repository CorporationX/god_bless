package faang.school.godbless.notification_facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CompletableFuture<Void> future = notificationManager.fetchNotification();
            futures.add(future);
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.thenRun(() -> {
            List<Notification> notifications = notificationManager.getNotifications();
            System.out.println("Список уведомлений:");
            for (Notification notification : notifications) {
                System.out.println("Id: " + notification.getId() + ", Сообщение: " + notification.getMessage());
            }
        });
        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
