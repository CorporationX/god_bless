package faang.school.godbless.BJS2_25100;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultConsumer {
    private final AtomicLong sumOfSquaredNumbers = new AtomicLong(0);

    public long add(long num) {
        return sumOfSquaredNumbers.addAndGet(num);
    }

    public static long launch(int n) {
        var requests = getSquareRequests(n);
        ResultConsumer consumer = new ResultConsumer();
        return fanOutFanIn(requests, consumer);
    }

    private static List<SquareRequest> getSquareRequests(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(SquareRequest::new)
                .collect(Collectors.toList());
    }

    private static long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
        var executor = Executors.newFixedThreadPool(requests.size());
        var futures = requests.stream()
                .map(request -> CompletableFuture.runAsync(
                        () -> request.longTimeSquare(resultConsumer), executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        shutdown(executor, requests.size());
        return resultConsumer.sumOfSquaredNumbers.get();
    }

    private static void shutdown(ExecutorService executor, int n) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(n, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
