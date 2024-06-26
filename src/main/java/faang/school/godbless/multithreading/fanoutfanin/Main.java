package faang.school.godbless.multithreading.fanoutfanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    private static final long START_PERIOD = 1;
    private static final long END_NUMBER = 10;

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> squareRequestList = new ArrayList<>();

        LongStream.rangeClosed(START_PERIOD, END_NUMBER)
                .forEach(i -> squareRequestList.add(new SquareRequest(i)));

        var result = fanOutFanIn(squareRequestList, resultConsumer);

        System.out.printf("Sum of digits from %d till %d is %d.\n", START_PERIOD, END_NUMBER, result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);

        try {
            List<CompletableFuture<Void>> futures = new ArrayList<>();

            for (SquareRequest squareRequest : requests) {
                var future = CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), threadPool);
                futures.add(future);
            }

            var allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
            allOf.join();

            return resultConsumer.getSumOfSquaredNumbers().get();
        } finally {
            threadPool.shutdown();
        }
    }

    public static Long fanOutFanInWithoutExecutorService(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (SquareRequest squareRequest : requests) {
            var future = CompletableFuture.runAsync(() ->
                    squareRequest.longTimeSquare(resultConsumer));
            futures.add(future);
        }

        var allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
