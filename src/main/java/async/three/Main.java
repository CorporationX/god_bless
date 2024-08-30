package async.three;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.join();

        executor.shutdown();

        return resultConsumer.getSumOfSquaredNumbers();
    }

    public static void launch() {
        List<SquareRequest> requests = LongStream.rangeClosed(1, 1000)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());

        ResultConsumer resultConsumer = new ResultConsumer(0L);

        Long result = fanOutFanIn(requests, resultConsumer);
        System.out.println(result);
    }
}
