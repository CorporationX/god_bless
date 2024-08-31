package faang.school.godbless.sprint4.fanout_fanin;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch(1, 1000);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(
                        () -> request.longTimeSquare(resultConsumer), executor)
                )
                .toList();

        executor.shutdown();
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        return resultConsumer.add(0L);
    }

    public static void launch(long lower, long upper) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> squareRequests = LongStream.rangeClosed(lower, upper)
                .mapToObj(SquareRequest::new)
                .toList();
        System.out.println("Result of summing squares: " + fanOutFanIn(squareRequests, resultConsumer));
    }
}
