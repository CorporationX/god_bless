package send_notifications_to_FB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    final static int NUMBER_OF_NOTIFICATION = 10;

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        List<CompletableFuture<Notification>> futureNotificationList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_NOTIFICATION; i++) {
            futureNotificationList.add(notificationManager.fetchNotification());
        }

        CompletableFuture.allOf(futureNotificationList.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    for (CompletableFuture<Notification> futureNotification : futureNotificationList) {
                        try {
                            Notification notification = futureNotification.get();
                            System.out.println("Notification №" + notification.getId() +
                                    " was created and added to the notification list");
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).join();
    }
}
