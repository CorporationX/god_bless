package faang.school.godbless.FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (SquareRequest request : requests) {
           futures.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
        try {
            if(!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(1000L);
        for (int i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }
        System.out.println(fanOutFanIn(requests, resultConsumer));
    }

}
