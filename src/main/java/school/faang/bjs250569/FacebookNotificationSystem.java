package school.faang.bjs250569;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class FacebookNotificationSystem {
    public static void main(String[] args) {

        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(0, 10)
                .mapToObj(i -> manager.fetchNotification(i, "Message " + i))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        manager.printNotifications();
    }
}