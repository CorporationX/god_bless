package faang.school.godbless.fanoutfanin3130;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        launch(1000, resultConsumer);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (SquareRequest request : requests) {
            futures.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor));
        }
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).get();
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch(int requestsQuantity, ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        List<SquareRequest> squareRequests = new ArrayList<>();
        for (int i = 1; i <= requestsQuantity; i++) {
            squareRequests.add(new SquareRequest((long) i));
        }
        Long result = fanOutFanIn(squareRequests, resultConsumer);
        System.out.println("Sum of square numbers from 1 to 1000 is " + result);
    }
}
