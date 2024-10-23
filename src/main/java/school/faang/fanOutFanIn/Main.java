package school.faang.fanOutFanIn;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final ExecutorService service =
            Executors.newCachedThreadPool();

    public static void main(String[] args) {

        launch();
        service.shutdown();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests,
                                   ResultConsumer resultConsumer) {
        List<CompletableFuture<Void>> allResults =
                requests.stream().map(r -> CompletableFuture.runAsync(() ->
                        r.longTimeSquare(resultConsumer), service)).toList();

        CompletableFuture
                .allOf(allResults.toArray(new CompletableFuture[0]))
                .join();

        return resultConsumer.getSum();
    }

    public static void launch() {
        List<SquareRequest> requests =
                IntStream.rangeClosed(1, 1000)
                        .mapToObj(o -> new SquareRequest((long) o))
                        .toList();
        ResultConsumer resultConsumer = new ResultConsumer(0L);
        Long sum = fanOutFanIn(requests, resultConsumer);
        System.out.println("Сумма квадратов чисел от 1 до 1000: " + sum);
    }
}
