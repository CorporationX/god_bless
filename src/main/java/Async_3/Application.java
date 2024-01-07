package Async_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    private static ExecutorService service = Executors.newFixedThreadPool(4);

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<ResultConsumer>> completableFuture = new ArrayList<>();
        for (SquareRequest squareRequest : requests) {
            completableFuture.add(CompletableFuture.supplyAsync(() -> {
                squareRequest.longTimeSquare(resultConsumer);
                return resultConsumer;
            }, service));
        }
        completableFuture.stream().map(n -> n.join()).toList();
        return resultConsumer.add((long) 0);
    }

    public static void launch(int n) {
        List<SquareRequest> list = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer((long) n);
        for (int i = 1; i <= n; i++) {
            list.add(new SquareRequest((long) i));
        }
        System.out.println("sum all square of 1 to " + n + ": " + fanOutFanIn(list, resultConsumer));
    }

    public static void main(String[] args) {
        launch(1000);
        service.shutdown();
    }

}
