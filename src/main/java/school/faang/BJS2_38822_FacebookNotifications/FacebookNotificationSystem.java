package school.faang.BJS2_38822_FacebookNotifications;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class FacebookNotificationSystem {
    private static final int NOTIFICATIONS_COUNT = 10;

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        CompletableFuture<?>[] fetchingFutures =
                IntStream.rangeClosed(1, NOTIFICATIONS_COUNT)
                .mapToObj(id -> manager.fetchNotification(id, String.format("Notification #%d", id)))
                        .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(fetchingFutures)
                .thenRun(() -> log.info("All notifications were fetched!"))
                .join();
    }
}
