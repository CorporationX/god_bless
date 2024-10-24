package school.faang.BJS2_38025_FanInFanOut;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class SumOfSquaresComputer {
    public void launch(long ceiling) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= ceiling; i++) {
            requests.add(new SquareRequest(i));
        }
        log.info("Sum of squares of numbers (1-{}): {}", ceiling, fanOutFanIn(requests, resultConsumer));
    }

    private Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        return CompletableFuture.allOf(
                        requests.stream()
                                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer)))
                                .toArray(CompletableFuture[]::new)
                )
                .thenApply(result -> resultConsumer.getSum())
                .join();
    }
}
