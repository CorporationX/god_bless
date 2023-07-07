package faang.school.godbless.multithreading.out_in;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        long expected = 0L;

        for (int i = 1; i <= 1000; i++) {
            expected += i * i;
        }

        System.out.println(expected);
        launch();
    }

    private static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        requests.forEach(
                request -> futures.add(
                        CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService)
                )
        );

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = IntStream.range(1, 1000)
                .mapToObj(i -> new SquareRequest((long) i))
                .toList();

        long result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println(result);
    }
}
