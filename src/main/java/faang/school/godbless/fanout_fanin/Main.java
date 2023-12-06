package faang.school.godbless.fanout_fanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requestList = List.of(
                new SquareRequest(10L),
                new SquareRequest(15L),
                new SquareRequest(20L),
                new SquareRequest(25L));

        ResultConsumer result = new ResultConsumer(0L);

        System.out.println("The result is: " + fanOutFanIn(requestList, result));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer){
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (SquareRequest request : requests){
            CompletableFuture<Void> result = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer));
            futures.add(result);

            CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

            try {
                result.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return resultConsumer.getSumOfSquaredNumbers().get();

    }
}
