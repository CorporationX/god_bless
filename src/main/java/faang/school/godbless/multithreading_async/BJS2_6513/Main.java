package faang.school.godbless.multithreading_async.BJS2_6513;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        launch();
        long end = System.currentTimeMillis() - start;
        System.out.println("It took " + end + " ms");
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<CompletableFuture<Void>> futureList = new ArrayList<>();

        requests.forEach(squareRequest -> futureList.add(
                CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), executorService
                ))
        );

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = LongStream.range(1, 1001)
                .boxed()
                .map(SquareRequest::new)
                .toList();
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));
    }
}
