package faang.school.godbless.fan_out;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0l);
        List<SquareRequest> requests = LongStream.range(1, 1001)
                .mapToObj(SquareRequest::new)
                .toList();

        System.out.println(fanOutFanIn(requests, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(squareRequest -> CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), poolThreads))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        try {
            poolThreads.shutdown();
            if (!poolThreads.awaitTermination(60, TimeUnit.SECONDS)) {
                poolThreads.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }
}
