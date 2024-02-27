package faang.school.godbless.fanout;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Main {
    public static void main(String... args) {
        launch();

    }

    public static void launch() {
        List<SquareRequest> requestList = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            requestList.add(new SquareRequest((long) i));
        }
        System.out.println("Square sum = " + fanOutFanIn(requestList, new ResultConsumer((long) 0)));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        requests.forEach(request -> tasks.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer))));
        CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)).join();
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultConsumer.getSumOfSquaredNumbers().get();
    }
}
