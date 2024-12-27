package school.faang.sprint_4.task_49913;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final int AMOUNT_OF_REQUESTS = 1000;
    private static final int NUMBER_OF_THREADS = AMOUNT_OF_REQUESTS / 5;
    private static final int AWAIT_TIME = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void main(String[] args) {
        launch();

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.info("Await timed out. Shutting down...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Main thread interrupted. Shutting down...");
            executor.shutdownNow();
        }
        log.info("Executor shut down");
    }

    private static void launch() {
        List<SquareRequest> squareRequests = LongStream.rangeClosed(1, AMOUNT_OF_REQUESTS)
                .mapToObj(SquareRequest::new)
                .toList();

        Long result = fanOutFanIn(squareRequests, new ResultConsumer((long) 0));
        System.out.println("Sum of squares from 1 to " + AMOUNT_OF_REQUESTS + ": " + result);
    }

    private static Long fanOutFanIn(@NonNull List<SquareRequest> requests,
                                    @NonNull ResultConsumer resultConsumer) {
        requests.stream()
                .map(request ->
                        CompletableFuture.runAsync(() ->
                                request.longTimeSquare(resultConsumer),
                                executor))
                .reduce(CompletableFuture::allOf)
                .ifPresent(CompletableFuture::join);
        return resultConsumer.getSum();
    }
}
