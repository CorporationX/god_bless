package faang.school.godbless.facebook_sending_notifications;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        CompletableFuture<Void>[] futures = new CompletableFuture[10];
        for(int i = 0; i < futures.length; i++) {
            futures[i] = notificationManager.fetchNotification(new Notification(i + 1, "message-" + (i + 1)));
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);
        allFutures.join();

        notificationManager.getNotifications().stream().forEach(notification -> System.out.println(notification.getMessage()));
    }
}
