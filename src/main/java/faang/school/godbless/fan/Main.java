package faang.school.godbless.fan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        launch(1000, resultConsumer);
    }
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        requests.forEach(squareRequest -> {
            futures.add(CompletableFuture.runAsync(()->squareRequest.longTimeSquare(resultConsumer),executorService));
        });
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).get();
        executorService.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
    public static void launch(int quantity,ResultConsumer resultConsumer) throws ExecutionException, InterruptedException {
        List<SquareRequest> squareRequests = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            squareRequests.add(new SquareRequest((long) i));
        }
        Long result = fanOutFanIn(squareRequests,resultConsumer);
        System.out.println(result);
    }
}
