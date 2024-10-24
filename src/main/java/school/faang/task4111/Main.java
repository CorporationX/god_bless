package school.faang.task4111;

import school.faang.task4111.notification.NotificationManager;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        List<CompletableFuture<Void>> futures = IntStream.range(0, 10)
                .mapToObj(i -> manager.fetchNotification(i, "Сообщение №" + i))
                .toList();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        manager.printAllNotification();
        manager.shutdown();
    }
}
