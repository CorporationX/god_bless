package faang.school.godbless.sprint2.fanOutFanIn;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

    private static final int POOL_SIZE = 8;

    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = launch();
        Long result = fanOutFanIn(requests, resultConsumer);

        log.info("Результат: {}", result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<CompletableFuture<Void>> requestsFuture = requests.stream()
                .map((request) -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toList();

        long result = CompletableFuture.allOf(requestsFuture.toArray(new CompletableFuture[0]))
                .thenApply((v) -> resultConsumer.getSumOfSquaredNumbers().get())
                .join();

        executorService.shutdown();
        return result;
    }

    public static List<SquareRequest> launch() {
        return LongStream.rangeClosed(1, 10)
                .boxed()
                .map(SquareRequest::new)
                .toList();
    }
}
