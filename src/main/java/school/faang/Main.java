package school.faang;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_POOL_SIZE = 4;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Void>> futureNotifications = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> notificationManager.fetchNotification(i, "Message " + i, executor))
                .toList();

        CompletableFuture.allOf(futureNotifications.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
    }
}
