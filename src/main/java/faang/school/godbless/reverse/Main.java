package faang.school.godbless.reverse;

import faang.school.godbless.SquareRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) {
        launch();
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        ExecutorService executor = Executors.newFixedThreadPool(min(requests.size(), 6));
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(request -> {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->request.longTimeSquare(resultConsumer), executor);
            futures.add(completableFuture);
        });
        executor.shutdown();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSumOfSquareNumbers();
    }

    private static void launch(){
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        LongStream.range(1, 1001).forEach((number)->requests.add(new SquareRequest(number)));

        System.out.println("Result = " + fanOutFanIn(requests, resultConsumer));
    }
}
