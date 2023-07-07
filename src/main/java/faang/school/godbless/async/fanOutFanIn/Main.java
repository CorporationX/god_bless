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

        List<CompletableFuture<Void>> completableFutureList = requests.stream().map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), pool)).toList();

        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();

        pool.shutdown();

        return resultConsumer.getSumOfSquaredNumbers();
    }

    private static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            requests.add(new SquareRequest(i));
        }

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        AtomicLong outFanIn = fanOutFanIn(requests, resultConsumer);

        System.out.println(outFanIn);
    }
}
