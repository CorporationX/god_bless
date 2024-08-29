package faang.school.godbless.BJS2_24920;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        NotificationManager notificationManager = new NotificationManager(executor);
        var futures = IntStream.range(0, 100)
                .mapToObj(i -> notificationManager.fetchNotification())
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        notificationManager.getNotifications().forEach(System.out::println);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}