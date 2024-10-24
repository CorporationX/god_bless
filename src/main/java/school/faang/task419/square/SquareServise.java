package school.faang.task419.square;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SquareServise {
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), service))
                .toList();
        CompletableFuture<Void> future = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        future.join();
        return resultConsumer.getSum();
    }

    public static void shutdown() {
        service.shutdown();
        try {
            if (service.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("Ошибка");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }
        Long result = fanOutFanIn(requests, new ResultConsumer(0L));
        shutdown();
        System.out.println("Сумма квадратов чисел от 1 до 1000: " + result);
    }
}
