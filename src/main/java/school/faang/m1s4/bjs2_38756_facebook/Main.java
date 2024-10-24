package school.faang.m1s4.bjs2_38756_facebook;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int N_NOTIFICATIONS = 1000;

    public static void main(String[] args) {

        NotificationManager manager = new NotificationManager();

        ExecutorService service = Executors.newFixedThreadPool(10);

        List<CompletableFuture<Void>> futures = IntStream.range(0, N_NOTIFICATIONS)
                .mapToObj(i -> manager.fetchNotification(i, "Сообщение " + i, service))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        manager.printNotifications();

        service.shutdown();
        try {
            if(!service.awaitTermination(300, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
