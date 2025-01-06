package derschrank.sprint04.task11.bjstwo_50572;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NotificationManagerInterface manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(0, 100)
                .mapToObj(i -> CompletableFuture.runAsync(
                        () -> manager.fetchNotification(i, "Message #" + i)
                ))
                .toList();
        CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        ).join();

        manager.printNotifications();
    }
}
