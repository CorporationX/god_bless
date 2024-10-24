package school.faang.fourthStream.BJS2_38020;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Slf4j
public class Calculator {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final long THRESHOLD = 1000;
    private static final long TERMINATION_SECONDS = 30;

    public void launch() {
        List<SquareRequest> requests = createList();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        Long sum = fanOutFanIn(requests, resultConsumer);
        log.info("Сумма квадратов чисел от 1 до {}: {}", THRESHOLD, sum);
    }

    public void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }

    private Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() ->
                        request.longTimeSquare(resultConsumer), EXECUTOR))
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        return resultConsumer.getSum();
    }

    private List<SquareRequest> createList() {
        return LongStream.rangeClosed(1, THRESHOLD)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());
    }
}
