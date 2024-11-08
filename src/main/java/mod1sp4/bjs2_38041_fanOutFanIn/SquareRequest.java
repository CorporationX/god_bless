package mod1sp4.bjs2_38041_fanOutFanIn;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

@Slf4j
@Data
public class SquareRequest {
    private static final long SQUARES_RANGE_START = 1;
    private static final long SQUARES_RANGE_END = 1000;
    private static final long MIN_TIMEOUT = 3000L;
    private static final int RANDOM_TIMEOUT_BOUND = 1000;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(RANDOM_TIMEOUT_BOUND);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while sleeping: {}", e.getMessage());
            throw new IllegalStateException(e);
        } finally {
            resultConsumer.add(number * number);
        }
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> completableFutureList = requests.stream()
                .map(squareRequest -> CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executorService))
                .toList();
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSum();
    }

    public static void launch() {
        List<SquareRequest> squareRequestList = LongStream.range(SQUARES_RANGE_START, SQUARES_RANGE_END + 1)
                .mapToObj(SquareRequest::new)
                .toList();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.printf("Сумма чисел от %d до %d: %d", SQUARES_RANGE_START, SQUARES_RANGE_END, fanOutFanIn(squareRequestList, resultConsumer));
        shuttingDownExecutor();
    }

    public static void shuttingDownExecutor() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error shutting down executor: {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }
}

