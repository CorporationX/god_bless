package school.faang.bjs249926;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        System.out.println("main started");
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            requests.add(new SquareRequest((long) i));
        }
        Long l = fanOutFanIn2(requests, resultConsumer);
        System.out.println("final result : " + l);
        System.out.println("main ended");
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = requests.stream()
                .map(el -> CompletableFuture.runAsync(() -> el.longTimeSquare(resultConsumer)))
                .toList();

        CompletableFuture<Void> result = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        result.join();
        return resultConsumer.getSum();
    }

    public static Long fanOutFanIn2(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        try {
            List<CompletableFuture<Void>> futures = requests.stream()
                    .map(el -> CompletableFuture.runAsync(() -> el.longTimeSquare(resultConsumer), executor))
                    .toList();

            CompletableFuture<Void> result = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
            result.join();
        } finally {
            executor.shutdown(); // Always shut down the executor to free resources
        }

        return resultConsumer.getSum();
    }

}
