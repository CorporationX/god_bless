package fan.out.fan.in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int MAX_REQUESTS = 100;

    public static void main(String[] args) {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> squares = new ArrayList<>();

        for (long i = 0; i <= MAX_REQUESTS; i++) {
            squares.add(new SquareRequest(i));
        }

        System.out.printf("Результат вычислений: %d", fanOutFanIn(squares, consumer));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        requests.forEach(request -> futures.add(
            CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
        );

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
