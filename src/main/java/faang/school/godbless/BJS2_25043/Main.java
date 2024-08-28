package faang.school.godbless.BJS2_25043;

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
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture> futures = new ArrayList<>();

        for (SquareRequest request : requests) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                request.longTimeSquare(resultConsumer);
            }, executor);
            futures.add(completableFuture);
        }

        CompletableFuture allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();
        executor.shutdown();

        return resultConsumer.getSum();
    }

    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 0; i < 1001; i++) {
            requests.add(new SquareRequest(i));
        }
        Long result = fanOutFanIn(requests,resultConsumer);

        System.out.println("Общая сумма квадратов от 1 до 1000: " + result);
    }
}
