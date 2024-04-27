package faang.school.godbless.Async.FAN;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    private static final int THREAD_POOL_SIZE = 100;
    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        CompletableFuture[] futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toArray(CompletableFuture[]::new);


        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        allOf.join();

        executor.shutdown();

        return resultConsumer.getResult();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum of squared numbers from 1 to 1000: " + result);
    }
}
