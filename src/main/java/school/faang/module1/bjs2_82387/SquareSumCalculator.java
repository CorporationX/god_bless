package school.faang.module1.bjs2_82387;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.LongStream;

@Slf4j
@RequiredArgsConstructor
public class SquareSumCalculator {

    private static final long RANGE_START = 1L;
    private static final long RANGE_END = 1000L;
    private final ExecutorService executor;

    private Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture.allOf(
                requests.stream()
                        .map(request -> CompletableFuture.runAsync(
                                () -> request.longTimeSquare(resultConsumer), executor
                        ))
                        .toArray(CompletableFuture[]::new)
        ).join();
        return resultConsumer.getSum();
    }

    public void launch() {
        List<SquareRequest> squareRequests = LongStream.rangeClosed(RANGE_START, RANGE_END)
                .mapToObj(SquareRequest::new)
                .toList();
        ResultConsumer resultConsumer = new ResultConsumer();
        long result = fanOutFanIn(squareRequests, resultConsumer);
        log.info("Сумма квадратов чисел от 1 до 1000: {}", result);
    }
}