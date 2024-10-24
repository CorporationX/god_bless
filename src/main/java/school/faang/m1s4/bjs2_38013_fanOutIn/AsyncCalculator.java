package school.faang.m1s4.bjs2_38013_fanOutIn;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AsyncCalculator {
    private static final long TERMINATION_TIME = 300L;

    private final ExecutorService service;

    public AsyncCalculator(int numberThreads) {
        service = Executors.newFixedThreadPool(numberThreads);
    }

    public Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request ->
                        CompletableFuture.runAsync(() ->
                                request.longTimeSquare(resultConsumer), service))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        shutdownPool();

        return resultConsumer.getSum();
    }

    private void shutdownPool() {
        service.shutdown();
        try {
            if (!service.awaitTermination(TERMINATION_TIME, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}
