package Multithreading.bc3332_Sending_Notifications_to_Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Application {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        List<CompletableFuture<Notification>> futureNotifications = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futureNotifications.add(notificationManager.fetchNotification());
        }

        CompletableFuture.allOf(futureNotifications.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        futureNotifications.forEach(notification -> {
                            try {
                                System.out.println("Message ID: " + notification.get().getId() + ", Message: " + notification.get().getMessage());
                            } catch (InterruptedException | ExecutionException e) {
                                throw new RuntimeException(e);
                            }
                        })
                ).join();

        System.out.println("Finished");
    }
}
