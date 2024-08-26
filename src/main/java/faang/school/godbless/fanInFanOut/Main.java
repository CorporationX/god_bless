package faang.school.godbless.fanInFanOut;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(
                    () -> request.longTimeSquare(resultConsumer), executorService);
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("FanOutFanIn interrupted");
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }

    private static void launch(long n) {
        List<SquareRequest> requests = new LinkedList<>();
        for (long  i = 1; i <= n; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        Long result = fanOutFanIn(requests, resultConsumer);

        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        launch(10);
        launch(5);
    }
}
