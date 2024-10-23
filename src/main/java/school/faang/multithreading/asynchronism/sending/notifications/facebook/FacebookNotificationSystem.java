package school.faang.multithreading.asynchronism.sending.notifications.facebook;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class FacebookNotificationSystem {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(IntStream.range(0, 10)
                .mapToObj(i -> manager.fetchNotification(i, "Сообщение " + i)).toArray(CompletableFuture[]::new));
        allFutures.join();
        manager.shutdown();
        manager.printNotifications();
    }
}
