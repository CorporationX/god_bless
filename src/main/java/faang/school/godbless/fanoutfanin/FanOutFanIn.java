package faang.school.godbless.fanoutfanin;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FanOutFanIn {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture<Void> futures = CompletableFuture.allOf(requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toArray(CompletableFuture[]::new));
        futures.join();
        executorService.shutdown();
        return resultConsumer.getSum();
    }
}