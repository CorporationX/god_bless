package faang.school.godbless.async.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    private static AtomicLong fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService pool = Executors.newFixedThreadPool(requests.size());

        CompletableFuture<Void> future =  CompletableFuture.runAsync(() -> {
            for (SquareRequest request : requests) {
                request.longTimeSquare(resultConsumer);
            }
        }, pool);

        CompletableFuture.allOf(future).join();

        pool.shutdown();

        return resultConsumer.getSumOfSquaredNumbers();
    }

    private static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 15; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        AtomicLong outFanIn = fanOutFanIn(requests, resultConsumer);

        System.out.println(outFanIn);
    }
}
