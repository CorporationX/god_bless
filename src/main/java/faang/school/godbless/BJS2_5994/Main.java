package faang.school.godbless.BJS2_5994;

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
        ExecutorService pool = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> poolCompletableFuture = new ArrayList<>();

        for (SquareRequest request : requests) {
            CompletableFuture<Void> futureTask = CompletableFuture.runAsync(() ->
                    request.longTimeSquare(resultConsumer), pool);
            poolCompletableFuture.add(futureTask);
        }

        pool.shutdown();

        CompletableFuture.allOf(poolCompletableFuture.toArray(new CompletableFuture[0])).join();

        return resultConsumer.getSumOfSquaredNumbers();
    }

    private static void launch() {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();

        for (long i = 1L; i <= 1000; i++) {
            requests.add(new SquareRequest(2L));
        }
        System.out.println(("Result: " + fanOutFanIn(requests, consumer)));
    }
}
