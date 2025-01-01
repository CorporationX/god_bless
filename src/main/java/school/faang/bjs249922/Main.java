package school.faang.bjs249922;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final long INIT_NUMBER = 0L;
    private static final long UPPER_NUMBER = 1000L;
    private static final Long INIT_SUM = 0L;

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture
                        .runAsync(() -> request.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        return resultConsumer.getSum();
    }

    public static void launch() {
        List<SquareRequest> squareRequests = LongStream.rangeClosed(INIT_NUMBER, UPPER_NUMBER)
                .mapToObj(SquareRequest::new)
                .toList();

        ResultConsumer resultConsumer = new ResultConsumer(INIT_SUM);
        Long resultSum = fanOutFanIn(squareRequests, resultConsumer);
        log.info("Sum of squares of numbers from {} to {} is {}", INIT_NUMBER, UPPER_NUMBER, resultSum);
    }
}