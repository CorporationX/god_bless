package school.faang.fourthStream.BJS2_38792;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int NOTIFICATIONS_COUNT = 10;
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(0, NOTIFICATIONS_COUNT)
                .mapToObj(i -> CompletableFuture.runAsync(manager::fetchNotification))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        manager.shutdown();
        manager.printNotifications();
    }
}
