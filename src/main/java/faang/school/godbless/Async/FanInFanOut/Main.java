package faang.school.godbless.Async.FanInFanOut;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        launch();
    }
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        CompletableFuture<Void>[] futures = new CompletableFuture[requests.size()];

        for (int i = 0; i < requests.size(); i++) {
            SquareRequest request = requests.get(i);

            futures[i] = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);

        try {
            allOf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        return resultConsumer.getResult();
    }

    public static void launch() {
        List<SquareRequest> requests = new CopyOnWriteArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum of squared numbers from 1 to 1000: " + result);
    }

}
