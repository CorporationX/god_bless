package faang.school.godbless.BJS2_24970;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class Main {
    static final int MAX_NUM = 1000;

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = LongStream.range(1, MAX_NUM + 1)
                .mapToObj(SquareRequest::new).toList();

        System.out.println(fanOutFanIn(requests, resultConsumer));
    }

    public static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(squareRequest -> CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }
}
