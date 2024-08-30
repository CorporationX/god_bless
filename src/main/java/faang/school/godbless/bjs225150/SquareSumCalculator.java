package faang.school.godbless.bjs225150;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SquareSumCalculator {

    List<SquareRequest> squareRequests = new ArrayList<>();
    ResultConsumer resultConsumer = new ResultConsumer(0L);

    public void launch(int numTotal) {
        for (long i = 1; i <= numTotal; i++) {
            squareRequests.add(new SquareRequest(i));
        }
        System.out.println(fanOutFanIn(squareRequests, resultConsumer));
    }

    private Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        for (var request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService);
            futures.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
