package faang.school.godbless.sprint4.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    private static final int QUANTITY_OF_REQUESTS = 1000;
    private static final List<SquareRequest> requests = new ArrayList<>();
    private static final ResultConsumer resultConsumer = new ResultConsumer(0L);
    private static ExecutorService executor;

    public static void main(String[] args) {
        launch();
        executor.shutdown();
    }

    private static Long fanOutFanIn() {
        CompletableFuture
                .allOf(streamOfCompletableFutures()
                        .toArray(CompletableFuture[]::new))
                .join();
        return resultConsumer.add(0L);
    }

    private static Stream<CompletableFuture<Void>> streamOfCompletableFutures() {
        return requests.stream()
                .map(request -> CompletableFuture
                        .runAsync(() -> request.longTimeSquare(resultConsumer), executor));
    }

    private static void launch() {
        LongStream.rangeClosed(1, QUANTITY_OF_REQUESTS)
                .forEach(number -> requests.add(new SquareRequest(number)));
        executor = Executors.newFixedThreadPool(requests.size());
        System.out.println(fanOutFanIn());
    }
}
