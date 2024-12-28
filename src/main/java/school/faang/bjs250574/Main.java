package school.faang.bjs250574;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        System.out.println("main started");
        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(0, 10)
                .mapToObj(i -> manager.fetchNotification(i, "Message " + i))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        manager.printNotifications();
        System.out.println("main ended");
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

}
