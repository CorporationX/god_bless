package faang.school.godbless.fanOutFanIn;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<SquareRequest> requests = generateRequests(1, 1000);
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long sum = fanOutFanIn(requests, resultConsumer);
        System.out.println("Sum of squared numbers: " + sum);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        CompletableFuture<?>[] futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> {
                    System.out.printf("Thread %s processing request for number %d%n",
                            Thread.currentThread().getName(), request.number());
                    request.longTimeSquare(resultConsumer);
                }, executor))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static List<SquareRequest> generateRequests(int start, int end) {
        List<SquareRequest> requests = new CopyOnWriteArrayList<>();
        for (int i = start; i <= end; i++) {
            requests.add(new SquareRequest((long) i));
        }
        return requests;
    }

}
