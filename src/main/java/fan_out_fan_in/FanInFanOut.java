package fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FanInFanOut {
    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        launch(1, 1000, resultConsumer);
    }

    public static void launch(int from, int to, ResultConsumer resultConsumer) {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = from; i <= to; i++) {
            requests.add(new SquareRequest(i));
        }
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("The sum of the squares of numbers from " +
                from + " to " + to + " is equal to " + result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();

        for (SquareRequest request : requests) {
            completableFutureList.add(CompletableFuture.runAsync(() ->
                    request.longTimeSquare(resultConsumer), executor));
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                completableFutureList.toArray(new CompletableFuture[0]));

        allFutures.join();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
