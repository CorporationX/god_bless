package school.faang.task_50567;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        NotificationManager notificationManager = new NotificationManager();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<CompletableFuture<Notification>> futures = IntStream.range(0, POOL_SIZE)
                .mapToObj(i -> {
                    try {
                        return notificationManager.fetchNotification(executorService);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[POOL_SIZE]));
        allFutures.join();

        notificationManager.printNotifications();
    }
}