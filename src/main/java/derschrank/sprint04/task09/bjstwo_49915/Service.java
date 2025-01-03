package derschrank.sprint04.task09.bjstwo_49915;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Service {
    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(
                        () -> request.longTimeSquare(resultConsumer)
                ))
                .toList();

        (CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))).join();
        return resultConsumer.getSum();
    }

    public static void launch(int n) {
        if (n < 0) {
            n *= -1;
        }
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            requests.add(new SquareRequest((long) i));
        }

        ResultConsumer resultConsumer = new ResultConsumer();
        long result = fanOutFanIn(requests, resultConsumer);
        System.out.printf("Sum of square of numbers from 1 to %d is: %d%n", n, result);
    }
}
