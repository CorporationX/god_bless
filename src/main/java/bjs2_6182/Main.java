package bjs2_6182;

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
        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(squareRequest -> futures.add(CompletableFuture.runAsync(() -> {
            squareRequest.longTimeSquare(resultConsumer);
        }, service)));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        service.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> request = new ArrayList<>();

        for (long i = 1L; i < 1000L; i++) {
            request.add(new SquareRequest(i));
        }

        long result = fanOutFanIn(request, consumer);

        System.out.println(result);
    }
}
