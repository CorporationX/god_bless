package faang.school;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Notification>> futureNotifications = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureNotifications.add(manager.fetchNotification());
        }
        futureNotifications.forEach(CompletableFuture::join);

        CompletableFuture.allOf(futureNotifications.toArray(CompletableFuture[]::new))
                .thenRun(() -> futureNotifications.forEach(notification -> {
                    try {
                        System.out.println(notification.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })).join();
        System.out.println("Done");
    }
}
