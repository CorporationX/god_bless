package faang.school.godbless.multithreading.async.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FanOutFanIn {
    public static List<SquareRequest> requests = new ArrayList<>();

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<ResultConsumer>> futures = new ArrayList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<ResultConsumer> squareRequest = CompletableFuture.supplyAsync(() -> {
                request.longTimeSquare(resultConsumer);
                return resultConsumer;
            }, executor);
            futures.add(squareRequest);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();


    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        for (long i = 1L; i <= 1000; i++) {
            SquareRequest squareRequest = new SquareRequest(i);
            requests.add(squareRequest);
        }
        System.out.println(fanOutFanIn(requests, resultConsumer));
    }
}
