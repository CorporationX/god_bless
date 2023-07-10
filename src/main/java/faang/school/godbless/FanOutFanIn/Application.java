package faang.school.godbless.FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        List<SquareRequest> list = new ArrayList<>();

        for (long i = 1; i <= 1000; i++) {
            list.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        System.out.println(fanOutFanIn(list, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> completableFutures = requests.stream()
                .map(squareRequest ->
                        CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executor))
                .toList();

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
