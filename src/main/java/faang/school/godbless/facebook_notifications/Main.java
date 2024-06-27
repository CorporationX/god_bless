package faang.school.godbless.facebook_notifications;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static final int NOTIFICATION_NUM = 10;

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        List<CompletableFuture<Void>> futureNotificationList = IntStream.range(0, NOTIFICATION_NUM)
                .mapToObj(i -> notificationManager.fetchNotification(i, String.valueOf(i)))
                .toList();

        CompletableFuture<Void> voidCompletableFuture
                = CompletableFuture.allOf(futureNotificationList.toArray(CompletableFuture[]::new));

        voidCompletableFuture.join();

        System.out.println(notificationManager.getNotificationList());

        notificationManager.closeNotificationManager();
    }
}
