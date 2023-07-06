package Multithreading.bc3131_Fan_out_Fan_In;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    static List<SquareRequest> numbers = new ArrayList<>();
    ResultConsumer resultConsumer = new ResultConsumer(0L);

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture<Long> res = CompletableFuture.runAsync(() -> {
            requests.forEach(squareRequest -> squareRequest.longTimeSquare(resultConsumer));
            return resultConsumer.getSumOfSquaredNumbers().get();
        }, executorService);


        return null;
    }

    public static void launch() {
        for (long i = 1; i <= 1000; i++) {
            numbers.add(new SquareRequest(i));
        }
        long result = fanOutFanIn(numbers, resultConsumer);
        System.out.println(result);

    }
}
