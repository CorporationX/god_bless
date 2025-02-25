package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SEIZE = 20;
    public static final int REQUEST_COUNT = 1000;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SEIZE);

    private static void fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= REQUEST_COUNT; ++i) {
            requests.add(new SquareRequest((long) i));
        }
        fanOutFanIn(requests, resultConsumer);
        executor.shutdown();
        System.out.println("Sum of squares = " + resultConsumer.getSum());
    }

    public static void main(String[] args) {
        launch();
    }
}
