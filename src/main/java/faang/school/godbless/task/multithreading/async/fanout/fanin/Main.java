package faang.school.godbless.task.multithreading.async.fanout.fanin;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_REQUEST = 1000;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_REQUEST;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final ResultConsumer resultConsumer = new ResultConsumer(0L);
    private static final List<CompletableFuture<Void>> futures = new ArrayList<>();
    private static List<SquareRequest> requests = getRequests();

    public static void main(String[] args) {
        Long result = fanOutFanIn();
        log.info("Result: {}", result);
        executor.shutdown();
    }

    public static Long fanOutFanIn() {
        futures.addAll(runTask());
        waitResults();
        return resultConsumer.getSumOfSquaredNumbers().get();
    }

    private static List<CompletableFuture<Void>> runTask() {
        return requests
                .stream()
                .map(request -> CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executor))
                .toList();
    }

    private static void waitResults() {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }

    private static List<SquareRequest> getRequests() {
        return LongStream
                .rangeClosed(1, NUMBER_OF_REQUEST)
                .mapToObj(SquareRequest::new)
                .toList();
    }
}
