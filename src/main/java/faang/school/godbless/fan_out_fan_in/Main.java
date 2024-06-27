package faang.school.godbless.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final long START_NUMBER = 1;
    public static final long END_NUMBER = 10;

    public static void main(String[] args) {
        launch(new ArrayList<>());
    }

    public static void launch(List<SquareRequest> requests) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        for (long i = START_NUMBER; i <= END_NUMBER; i++) {
            requests.add(new SquareRequest(i));
        }
        Long squareResult = fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum squares of numbers from " + START_NUMBER + " to " + END_NUMBER + " is: " + squareResult);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        for (SquareRequest squareRequest : requests) {
            CompletableFuture<Void> completableFuture = CompletableFuture
                    .runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executorService);
            completableFutures.add(completableFuture);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allOf.join();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
