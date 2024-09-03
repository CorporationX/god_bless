package faang.school.godbless.BJS225183;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void launch() {
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }
        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println(result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());
        CompletableFuture<Void> futures = CompletableFuture.allOf(requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService))
                .toArray(CompletableFuture[]::new));
        futures.join();
        executorService.shutdown();
        return resultConsumer.getSum();
    }

    public static void main(String[] args) {
        launch();
    }
}
