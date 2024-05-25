package FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(request ->
                futures.add(CompletableFuture.runAsync(() ->
                        request.longTimeSquare(resultConsumer), executorService)));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();
        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        requests.forEach(request -> fanOutFanIn(requests, resultConsumer));
    }
}
