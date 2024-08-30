package faang.school.godbless.sprint4.facebook;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        List<CompletableFuture<Void>> results =  IntStream.range(0, 100)
                .mapToObj(i -> manager.fetchNotification())
                .toList();

        manager.shutdownExecutor();
        CompletableFuture.allOf(results.toArray(CompletableFuture[]::new)).join();
        manager.getNotifications().forEach(System.out::println);
    }
}
