package faang.school.godbless.multithreading.async.fanOutFanIn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        launch(1, 1000);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        requests.forEach(request -> futures.add(CompletableFuture
                .runAsync(() -> request.longTimeSquare(resultConsumer), executor)));
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executor.shutdown();
        return resultConsumer.get();
    }

    public static void launch(long begin, long end) {
        ResultConsumer consumer = new ResultConsumer(0L);
        List<SquareRequest> squares = new ArrayList<>();

        for (long i = begin; i <= end; i++) {
            squares.add(new SquareRequest(i));
        }

        System.out.println(fanOutFanIn(squares, consumer));
    }
}
