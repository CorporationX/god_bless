package faang.school.godbless.reverse;

import faang.school.godbless.SquareRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        launch();
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (SquareRequest request : requests) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->request.longTimeSquare(resultConsumer), executor);
            futures.add(completableFuture);
        }
        executor.shutdown();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSumOfSquareNumbers();
    }

    private static void launch(){
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for(long i = 1; i<=1000; i++){
            requests.add(new SquareRequest(i));
        }
        System.out.println("Result = " + fanOutFanIn(requests, resultConsumer));
    }
}
