package faang.school.godbless.fanOut_FanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int N = 1000;

    public static void main(String[] args) {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        launch(requests);
        fanOutFanIn(requests, resultConsumer);
        System.out.println(resultConsumer.getSumOfSquaredNumbers());
    }

    public static void fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                request.longTimeSquare(resultConsumer);
            }, executor);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
    }

    private static void launch(List<SquareRequest> requests) {
        for (int i = 1; i <= N; i++) {
            requests.add(new SquareRequest((long) i));
        }
    }
}
