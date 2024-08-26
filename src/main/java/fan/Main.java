package fan;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 1000;
    private static final int REQUEST_COUNT = 1000;

    public static void main(String[] args) {
        List<SquareRequest> requests = initRequest();
        ResultConsumer consumer = new ResultConsumer(0L);
        log.info(fanOutFanIn(requests, consumer).toString());
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE)) {
            CompletableFuture[] futures = requests.stream()
                    .map(request -> CompletableFuture.runAsync(
                            () -> request.longTimeSquare(resultConsumer), executorService))
                    .toArray(CompletableFuture[]::new);
            CompletableFuture.allOf(futures).join();
            executorService.shutdown();
            return resultConsumer.getSumOfSquaredNumbers().get();
        }
    }

    private static List<SquareRequest> initRequest() {
        return LongStream.rangeClosed(1, REQUEST_COUNT)
                .mapToObj(SquareRequest::new)
                .toList();
    }
}
