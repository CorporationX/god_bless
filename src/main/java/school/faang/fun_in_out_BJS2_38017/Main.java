package school.faang.fun_in_out_BJS2_38017;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        final int THREADS = 1000;
        ExecutorService service = Executors.newFixedThreadPool(THREADS);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(squareRequest -> futures.add(CompletableFuture.supplyAsync(() -> {
            squareRequest.longTimeSquare(resultConsumer);
            return null;
        }, service)));

        service.shutdown();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSum();
    }

    public static void launch() {
        final long NUMBER_QUANTITY = 1000;
        final long START_NUMBER = 1;

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = START_NUMBER; i <= NUMBER_QUANTITY; i++) {
            requests.add(new SquareRequest(i));
        }
        long result = fanOutFanIn(requests, resultConsumer);
        System.out.printf("Sum of square numbers from %d to %d: %d", START_NUMBER,NUMBER_QUANTITY,result);
    }
}
