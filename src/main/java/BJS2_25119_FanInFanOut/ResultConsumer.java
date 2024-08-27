package BJS2_25119_FanInFanOut;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers;

    ResultConsumer(Long init) {
        sumOfSquaredNumbers = new AtomicLong(init);
    }

    public Long add(final Long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        CompletableFuture<Void> allThreads = CompletableFuture.allOf(requests.stream()
                .map(squareRequest -> CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), executor))
                .toArray(CompletableFuture[]::new));
        allThreads.join();
        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted!", e);
        }
        return resultConsumer.sumOfSquaredNumbers.get();
    }

    public void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            requests.add(new SquareRequest((long) i));
        }
        log.info("Generating sum of squares from 1 to {}", requests.size());
        Long result = fanOutFanIn(requests, this);
        log.info("The result of squared number is: {}", result);
    }
}
