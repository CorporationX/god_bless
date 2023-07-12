package Multithreading.bc3131_Fan_out_Fan_In;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

        public static void main(String[] args) {
            launch();
        }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> res = requests.stream()
                .map(squareRequest -> CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), executorService))
                .toList();
        CompletableFuture.allOf(res.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> numbers = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        for (long i = 1; i <= 1000; i++) {
            numbers.add(new SquareRequest(i));
        }
        long result = fanOutFanIn(numbers, resultConsumer);
        System.out.println(result);

    }
}
