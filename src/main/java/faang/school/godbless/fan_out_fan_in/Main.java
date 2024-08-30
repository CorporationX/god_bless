package faang.school.godbless.fan_out_fan_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        requests.forEach(request -> futures.add(CompletableFuture.runAsync(
                        () -> request.longTimeSquare(resultConsumer), executor)));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0]));
        allFutures.join();

        executor.shutdown();

        try {
            if (executor.awaitTermination(3, TimeUnit.MINUTES)) {
                System.out.println("Закончили работу");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }

    private static void launch() {
        List<SquareRequest> squareRequests = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            squareRequests.add(new SquareRequest((long) i));
        }

        Long result = fanOutFanIn(squareRequests, new ResultConsumer(0L));

        System.out.println("Результат = " + result);
    }
}
