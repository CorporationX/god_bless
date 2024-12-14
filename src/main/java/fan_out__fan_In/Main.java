package fan_out__fan_In;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {
    public static final int NUMBERS_MIN = 1;
    public static final int NUMBERS_MAX = 1000;
    public static Long fanOutFanIn(final List<SquareRequest> requests, final ResultConsumer resultConsumer) {
        ExecutorService service = Executors.newFixedThreadPool(requests.size());

        List<CompletableFuture<Void>> future =
                requests.stream().
                        map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), service))
                        .toList();

        CompletableFuture.allOf(future.toArray(new CompletableFuture[0])).join();
        service.shutdown();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> squareRequestList = LongStream.rangeClosed(NUMBERS_MIN, NUMBERS_MAX).mapToObj(num -> new SquareRequest(num)).toList();

        System.out.println(fanOutFanIn(squareRequestList, new ResultConsumer(1L)));
    }

    public static void main(String[] args) {
        launch();
    }
}
