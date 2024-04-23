package faang.school.godbless.FanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int N = 1000;

    public static void main(String[] args) {
        launch();
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService pool = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> results = new ArrayList<>();
        for (SquareRequest request : requests) {
            results.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), pool));
        }

        pool.shutdown();
        CompletableFuture.allOf(results.toArray(CompletableFuture[]::new)).join();
        return resultConsumer.getSumOfSquaredNumbers();
    }

    private static void launch() {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1L; i <= N; i++) {
            requests.add(new SquareRequest(i));
        }
        long result = fanOutFanIn(requests, consumer);
        System.out.println("result: " + result);
    }
}
