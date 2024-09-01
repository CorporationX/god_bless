package faang.school.godbless.BJS2_25207;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for(var request : requests) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(()
                    -> request.longTimeSquare(resultConsumer), executorService);
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for(long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println(result);
    }

    public static void main(String[] args) {
        launch();
        executorService.shutdown();
    }
}
