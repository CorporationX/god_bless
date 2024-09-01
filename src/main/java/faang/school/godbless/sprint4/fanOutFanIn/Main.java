package faang.school.godbless.sprint4.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class Main {
    private static final int QUANTITY_OF_REQUESTS = 1000;
    private static final List<SquareRequest> requests = new ArrayList<>();
    private static final ResultConsumer resultConsumer = new ResultConsumer(0L);
    private static ExecutorService executor;

    public static void main(String[] args) {
        launch();
    }

    private static AtomicLong fanOutFanIn() {
        CompletableFuture
                .allOf(listOfCompletableFutures()
                        .toArray(CompletableFuture[]::new))
                .join();
        return resultConsumer.getSumOfSquaredNumbers();
    }

    private static List<CompletableFuture<Void>> listOfCompletableFutures() {
        return requests.stream()
                .map(request -> CompletableFuture
                        .runAsync(() -> request.longTimeSquare(resultConsumer)))
//                        .thenRun(() -> System.out.println(Thread.currentThread().getName()))
                .toList();
    }

    private static void launch() {
        LongStream.rangeClosed(1, QUANTITY_OF_REQUESTS)
                .forEach(number -> requests.add(new SquareRequest(number)));
        executor = Executors.newFixedThreadPool(requests.size());
        System.out.println(fanOutFanIn());
        executor.shutdown();
    }
}
