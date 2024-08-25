package faang.school.godbless.BJS2_24940;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static final int REQUESTS_NUM = 1000;

    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        CompletableFuture<Long> finalResult = new CompletableFuture<>();
        var squareParts = new ArrayList<SquareRequest>();
        launch(squareParts, resultConsumer);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture<Void> futures = CompletableFuture.allOf(requests
                .stream()
                .map((squareRequest -> CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executorService)))
                .toArray(CompletableFuture[]::new));

        futures.join();
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }

    public static void launch(List<SquareRequest> squareParts, ResultConsumer resultConsumer) {
        for (long i = 1; i < REQUESTS_NUM; i++) {
            squareParts.add(new SquareRequest(i));
        }

        long finalResult = fanOutFanIn(squareParts, resultConsumer);
        System.out.println("Sum of squares = " + finalResult);
    }
}
