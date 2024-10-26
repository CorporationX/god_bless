package school.faang.fanoutfanin;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class FanOutFanInSystem {
    private static final int NUM_THREADS = 10;
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> results = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> {
                    request.longTimeSquare(resultConsumer);
                }, executor))
                .toList();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(results.toArray(CompletableFuture[]::new));
        allTasks.join();
        executor.shutdown();
        return resultConsumer.getSum();
    }

    public void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i < 1001; i++) {
            requests.add(new SquareRequest(i));
        }
        Long result = fanOutFanIn(requests, resultConsumer);
        log.info("Sum of squares of numbers from 1 to 1000: {}", result);
    }
}
