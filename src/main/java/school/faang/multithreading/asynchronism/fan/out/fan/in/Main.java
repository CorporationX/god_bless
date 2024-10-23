package school.faang.multithreading.asynchronism.fan.out.fan.in;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        var requests =
                LongStream.rangeClosed(1, 1000)
                        .mapToObj(SquareRequest::new)
                        .toList();
        var resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        log.info("Сумма квадратов чисел от 1 до 1000: {}", result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request ->
                        CompletableFuture.runAsync(() -> {
                            request.longTimeSquare(resultConsumer);
                        }, executor))
                .toList();
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        executor.shutdown();

        return resultConsumer.getSum();
    }
}
