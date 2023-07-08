package faang.school.godbless.Sprint5_1.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture> futures = new ArrayList<>();

        for (SquareRequest request : requests) {
            CompletableFuture future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }

        AtomicLong result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println("Sum of squares numbers = " + result);
    }

    public static void main(String[] args) {
        launch();
    }
}