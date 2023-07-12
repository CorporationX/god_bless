package faang.school.godbless.multithreading.out_in;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

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

        CompletableFuture.allOf(
                requests.stream()
                        .map(request -> CompletableFuture.runAsync(
                                () -> request.longTimeSquare(resultConsumer), executorService))
                        .toArray(CompletableFuture[]::new)
        ).join();

        executorService.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .toList();

        long result = fanOutFanIn(requests, new ResultConsumer(0L));
        System.out.println(result);
    }
}
