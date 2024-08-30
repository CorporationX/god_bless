package faang.school.godbless.FacebookSpam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        NotificationManager notificationManager = new NotificationManager();
        for (int i = 1; i <= 10; i++) {
            futures.add(notificationManager.fetchNotification(new Notification("Уведомление " + i)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        notificationManager.getNotifications().forEach(notification -> {
            System.out.println(notification.getTitle() + " " + notification.getId());
        });
    }
}
