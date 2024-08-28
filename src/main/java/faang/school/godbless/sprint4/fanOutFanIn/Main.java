package faang.school.godbless.sprint4.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    private static final List<SquareRequest> requests = new ArrayList<>();
    private static final ResultConsumer resultConsumer = new ResultConsumer(0L);
    private static ExecutorService executor;

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn() {
        CompletableFuture.allOf(requests.stream()
                .map(request -> CompletableFuture
                        .runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toArray(CompletableFuture[]::new)).join();
        return resultConsumer.add(0L);
    }

    public static void launch() {
        LongStream.rangeClosed(1, 1000).forEach(number -> requests.add(new SquareRequest(number)));
        executor = Executors.newFixedThreadPool(requests.size());
        System.out.println(fanOutFanIn());
        executor.shutdown();
    }
}
