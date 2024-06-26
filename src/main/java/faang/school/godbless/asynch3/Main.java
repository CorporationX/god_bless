package faang.school.godbless.asynch3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = getRequests();
        System.out.println(fanOutFanIn(requests, resultConsumer));
    }

    private static List<SquareRequest> getRequests() {
        return List.of(new SquareRequest(1L), new SquareRequest(2L),
                new SquareRequest(3L), new SquareRequest(4L), new SquareRequest(5L));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        requests.forEach(squareRequest -> completableFutures.add(CompletableFuture
                .runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executor)));
        CompletableFuture<Void> futures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        futures.join();
        executor.shutdown();
        return resultConsumer.sumOfSquaredNumbers().get();
    }
}
