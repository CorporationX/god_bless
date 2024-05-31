package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Void>> completableFuture = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            completableFuture.add(notificationManager.fetchNotification(i, "Hello" + i));
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFuture.toArray(new CompletableFuture[0]));
        voidCompletableFuture.join();

        for (Notification future : notificationManager.getNotifications()) {
            System.out.println(future.getId() + " " + future.getMessage());
        }
    }
}
