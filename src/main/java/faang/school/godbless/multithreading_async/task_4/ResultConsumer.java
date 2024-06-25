package faang.school.godbless.multithreading_async.task_4;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    private static final int SQUARE_REQUEST_COUNT = 1000;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(SQUARE_REQUEST_COUNT);

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public void launch() {
        final List<SquareRequest> squareRequests = new ArrayList<>();
        for (int i = 0; i <= SQUARE_REQUEST_COUNT; i++) {
            squareRequests.add(new SquareRequest((long) i));
        }
        log.info("Sum: {}", fanOutFanIn(squareRequests, this));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        final List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        requests.forEach(request -> {
            final CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), EXECUTOR);
            completableFutures.add(completableFuture);
        });
        final CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allFutures.join();
        return resultConsumer.sumOfSquaredNumbers.get();
    }

    public void shutdown() {
        EXECUTOR.shutdown();
    }
}