package org.example.service.facebookNotification;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(0, 10)
                .mapToObj(i -> manager.fetchNotification(i, "Message " + i))
                .toList();
        manager.shutdownPoolThreads();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            manager.getNotifications().forEach(notification -> {
                System.out.println(notification.getId() + " " + notification.getMessage());
            });
        });
        allFutures.join();
    }
}
