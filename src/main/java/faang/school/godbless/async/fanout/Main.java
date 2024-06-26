package faang.school.godbless.async.fanout;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class Main {

    public static void main(String[] args) {
        launch();
    }

    public static Long fanOutFanIn(List<SquareRequest> squareRequests, ResultConsumer resultConsumer) {
        var threadPool = Executors.newFixedThreadPool(squareRequests.size());
        List<CompletableFuture<Void>> futures = squareRequests
                .stream()
                .map(req -> CompletableFuture.runAsync(() -> req.longTimeSquare(resultConsumer), threadPool))
                .toList();
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }  finally {
            threadPool.shutdown();
        }
        return resultConsumer.getSumOfSquaredNumbers().longValue();
    }

    public static void launch() {
        List<SquareRequest> squareRequests = LongStream.rangeClosed(1, 1000)
                .boxed()
                .map(SquareRequest::new)
                .toList();
        var result = fanOutFanIn(squareRequests, new ResultConsumer(0L));
        log.info("The combined sum of squares of {} elements is {}", squareRequests.size(), result);
    }
}
