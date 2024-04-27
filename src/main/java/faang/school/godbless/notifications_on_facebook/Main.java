package faang.school.godbless.notifications_on_facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NotificationManager notificationManager = new NotificationManager();

        List<CompletableFuture<Notification>> notificationsRes = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            notificationsRes.add(notificationManager.fetchNotification(new Notification(i, "Notification" + i)));
        }

        CompletableFuture.allOf(notificationsRes.toArray(new CompletableFuture[0])).join();

        notificationManager.printNotifications();
    }
}