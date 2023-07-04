package sprint5.fanout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> squareRequests = new ArrayList<>();
        launch(squareRequests);
        System.out.println(fanOutFanIn(squareRequests, resultConsumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService service = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request ->
                        CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), service))
                .toList();
        service.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static void launch(List<SquareRequest> squareRequests) {
        for (int i = 1; i <= 1000; i++) {
            squareRequests.add(new SquareRequest((long) i));
        }
    }
}
