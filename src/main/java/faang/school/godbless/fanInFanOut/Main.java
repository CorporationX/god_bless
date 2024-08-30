package faang.school.godbless.fanInFanOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static final List<SquareRequest> squareRequests = new ArrayList<>();

    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        for (int i = 1; i <= 1000; i++) {
            SquareRequest squareRequest = new SquareRequest((long) i);
            squareRequests.add(squareRequest);
        }

        ResultConsumer resultConsumer = new ResultConsumer(new AtomicLong(0));

        long result = fanOutFanIn(squareRequests, resultConsumer);
        System.out.println(result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        requests.forEach(elem ->
                completableFutures.add(CompletableFuture.runAsync(() ->
                        elem.longTimeSquare(resultConsumer), executorService)));

        CompletableFuture<Void> completableFutureAllOf = CompletableFuture
                .allOf(completableFutures.toArray(new CompletableFuture<?>[0]));

        completableFutureAllOf.join();
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
