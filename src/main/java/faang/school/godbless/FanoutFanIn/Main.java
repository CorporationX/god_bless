package faang.school.godbless.FanoutFanIn;

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
        ExecutorService executor = Executors.newFixedThreadPool(100);
        List<CompletableFuture> all = new ArrayList<>();

        for (SquareRequest request : requests) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor);
            all.add(completableFuture);
        }

        CompletableFuture.allOf(all.toArray(all.toArray(new CompletableFuture[all.size()]))).join();
        executor.shutdown();
        return resultConsumer.add(0L);
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        System.out.println(fanOutFanIn(requests, resultConsumer));

    }
}
