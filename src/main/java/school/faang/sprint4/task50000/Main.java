package school.faang.sprint4.task50000;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int FROM_INTEGER = 1;
    private static final int TO_INTEGER = 1000;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        log.info("Запуск подсчета суммы квадратов чисел от {} до {}", FROM_INTEGER, TO_INTEGER);
        ResultConsumer result = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = FROM_INTEGER; i <= TO_INTEGER; i++) {
            requests.add(new SquareRequest((long) i));
        }

        long sum = fanOutFanIn(requests, result, executor);
        log.info("Сумма квадратов чисел от {} до {}: {}", FROM_INTEGER, TO_INTEGER, sum);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Работа пула потоков была прервана");
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }

    public static Long fanOutFanIn(List<SquareRequest> requests,
                                   ResultConsumer resultConsumer,
                                   ExecutorService executor) {
        List<CompletableFuture<Void>> results = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toList();
        CompletableFuture.allOf(results.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSum();
    }
}
