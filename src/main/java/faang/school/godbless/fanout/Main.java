package faang.school.godbless.fanout;

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

    public static void launch() {
        List<SquareRequest> requests = getRequests();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long squaresSum = fanOutFanIn(requests, resultConsumer);
        System.out.println(String.format("Squares sum: %d", squaresSum));
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        requests.forEach(request -> tasks.add(CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService)));
        CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)).join();


        executorService.shutdown();
        awaitTermination(executorService, 5L);
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static List<SquareRequest> getRequests() {
        List<SquareRequest> requests = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }
        return requests;
    }

    private static void awaitTermination(ExecutorService executorService, Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}