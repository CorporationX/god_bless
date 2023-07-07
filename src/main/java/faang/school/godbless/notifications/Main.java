package faang.school.godbless.notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Notification>> futuresNotifications = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            CompletableFuture<Notification> like = notificationManager.fetchNotification(new Notification("Like"));
            futuresNotifications.add(like);
        }

        CompletableFuture.allOf(futuresNotifications.toArray(new CompletableFuture[0]))
                .join();

        notificationManager.getNotifications().forEach((notification -> {
            System.out.println(notification.getMessage());
        }));
    }
}
