package school.faang.facebook_notifications_BJS2_38766;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class FacebookNotificationSystem {
    public static void main(String[] args) {
        final int RANGE_FROM = 0;
        final int RANGE_TO = 10;

        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(RANGE_FROM, RANGE_TO)
                .mapToObj(i -> manager.fetchNotification(i, "Message " + i))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        manager.printNotifications();
    }
}