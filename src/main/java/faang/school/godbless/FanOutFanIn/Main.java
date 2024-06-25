package faang.school.godbless.FanOutFanIn;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class Main {
    private static final int COUNT_THREAD = 10;
    private static final int COUNT_SQUARE_REQUESTS = 50;
    private static ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) {
        List<SquareRequest> squareRequestList = launch(COUNT_SQUARE_REQUESTS);
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(squareRequestList, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        CompletableFuture<Void>[] futures = new CompletableFuture[requests.size()];
        int index = 0;
        for (SquareRequest request : requests) {
            futures[index++] = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor);
        }
        CompletableFuture.allOf(futures).join();
        executor.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static List<SquareRequest> launch(int count) {
        return LongStream.rangeClosed(1, count)
                .parallel()
                .mapToObj(SquareRequest::new)
                .toList();
    }
}
