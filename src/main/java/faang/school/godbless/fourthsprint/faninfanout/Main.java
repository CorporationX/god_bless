package faang.school.godbless.fourthsprint.faninfanout;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    private static final int NUM_REQUESTS = 1000;

    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_REQUESTS);

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        return resultConsumer.getSum();
    }

    public static void launch() {
        List<SquareRequest> requests = LongStream.rangeClosed(1, NUM_REQUESTS)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum of squares: " + result);
    }
}
