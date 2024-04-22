package fanInFanOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class SquareRequest {
    private static final long MIN_TIMEOUT = 3000L;
    private final Long number;

    public SquareRequest(Long number) {
        this.number = number;
    }

    public void longTimeSquare(ResultConsumer resultConsumer) {
        var randomTimeout = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(MIN_TIMEOUT + randomTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            resultConsumer.add(number * number);
        }
    }

    public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        ExecutorService service = Executors.newCachedThreadPool();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        requests.forEach(squareRequest ->
                futures.add(CompletableFuture.runAsync(() ->
                        squareRequest.longTimeSquare(resultConsumer), service)
                ));

        futures.forEach(CompletableFuture::join);
        service.shutdown();

        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    public static void launch() {
        List<SquareRequest> requests = LongStream.range(1, 1001)
                .boxed()
                .map(SquareRequest::new)
                .toList();
        System.out.println(fanOutFanIn(requests, new ResultConsumer(0L)));

    }

    public static void main(String[] args) {
        launch();
    }
}
