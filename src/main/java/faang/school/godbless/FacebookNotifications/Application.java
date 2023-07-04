package faang.school.godbless.FacebookNotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Application {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
        NotificationManager notificationManager = new NotificationManager();

        for (int i = 0; i < 10; i++) {
            completableFutureList.add(notificationManager.fetchNotification());
        }

        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()]))
                .thenRun(() -> notificationManager.getNotificationList().forEach(System.out::println))
                .join();
    }
}
