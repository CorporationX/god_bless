package faang.school.godbless.fourth.FanOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Main {
    private static final int LAST_NUMBER = 1000;

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        var service = Executors.newFixedThreadPool(LAST_NUMBER);
        CompletableFuture<?>[] futures = new CompletableFuture<?>[LAST_NUMBER];

        for (int i = 0; i < LAST_NUMBER; i++) {
            int finalI = i;
            futures[i] = (CompletableFuture.runAsync(() -> requests.get(finalI).longTimeSquare(resultConsumer), service));
        }
        service.shutdown();

        CompletableFuture.allOf(futures).join();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= LAST_NUMBER; i++) {
            requests.add(new SquareRequest(i));
        }

        long result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println(result);
    }
}
