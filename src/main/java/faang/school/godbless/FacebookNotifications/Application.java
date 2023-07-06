package faang.school.godbless.FacebookNotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Application {
    private static NotificationManager notificationManager = new NotificationManager();

    public static void main(String[] args) {
        List<CompletableFuture> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CompletableFuture completableFuture = fetchNotification();
            futures.add(completableFuture);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        System.out.println(notificationManager.getNotificationList());
    }

    public static CompletableFuture fetchNotification() {

        var notificationFuture = CompletableFuture.supplyAsync(() -> {
            int ID = new Random().nextInt(1000);
            Notification notification = new Notification(ID,
                    "Message " + ID);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notificationManager.addNotification(notification);
            return notification;
        });

        return notificationFuture;
    }
}
