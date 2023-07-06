package faang.school.godbless.sprint_3.multithreading_future.facebook_notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        NotificationManager manager = new NotificationManager();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> future = manager.fetchNotification();
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> {
                    manager.getNotifications().stream()
                            .map(Notification::getMessage)
                            .forEach(System.out::println);
                })
                .join();
    }
}