package faang.school.godbless.BJS2_1370;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        launch();
    }
    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture<Void>[] futures = new CompletableFuture[requests.size()];

        for (int i = 0; i < requests.size(); i++) {
            SquareRequest squareRequest = requests.get(i);
            futures[i] = CompletableFuture.runAsync(() -> squareRequest.longTimeSquare(resultConsumer), executorService);
        }

        CompletableFuture.allOf(futures).join();
        executorService.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }


    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest((long) i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long result = fanOutFanIn(requests, resultConsumer);

        System.out.println("Result: " + result);
    }
}
