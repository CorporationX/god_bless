package faang.school.godbless.asynchrony_concurrency.fan_out_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final static int COUNT_THREADS = 1000;

    private final static ExecutorService EXECUTOR = Executors.newFixedThreadPool(COUNT_THREADS);

    private final static List<CompletableFuture<Void>> FUTURES = new ArrayList<>();

    private final static ResultConsumer resultConsumer = new ResultConsumer(0L);

    public static Long fanOutFanIn(List<SquareRequest> requests) {

        for (SquareRequest squareRequest : requests) {
            FUTURES.add(CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), EXECUTOR));
        }

        CompletableFuture.allOf(FUTURES.toArray(new CompletableFuture[0])).join();

        EXECUTOR.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch(List<SquareRequest> squareRequests) {
        for (long i = 0; i < 1000; i++) {
            squareRequests.add(new SquareRequest(i));
        }

        System.out.println(fanOutFanIn(squareRequests));
    }

    public static void main(String[] args) {
        List<SquareRequest> squareRequests = new ArrayList<>();
        launch(squareRequests);
    }
}