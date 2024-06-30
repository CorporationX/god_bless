package faang.school.godbless.fanoutfanin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class FanOutFanIn {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        List<SquareRequest> requests = new ArrayList<>();
        ResultConsumer resultConsumer = new ResultConsumer(0L);

        IntStream.rangeClosed(1, 1000)
                .forEach(i -> requests.add(new SquareRequest((long) i)));

        Long result = fanOutFanIn(requests, resultConsumer);

        System.out.println(result);
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executorService = Executors.newFixedThreadPool(requests.size());

        try {
            List<CompletableFuture<Void>> futures = new ArrayList<>();

            for (SquareRequest request : requests) {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executorService);
                futures.add(future);
            }

            CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
            allOf.join();

            return resultConsumer.getSum();
        } finally {
            executorService.shutdown();
        }
    }
}
