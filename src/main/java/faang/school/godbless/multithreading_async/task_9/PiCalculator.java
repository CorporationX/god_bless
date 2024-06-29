package faang.school.godbless.multithreading_async.task_9;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

@AllArgsConstructor
public class PiCalculator {
    private final ExecutorService executor;

    public double calculatePi(int n) {
        long pointInsideCount = IntStream.range(0, n).parallel()
            .mapToObj(index -> CompletableFuture.supplyAsync(Point::new, executor))
            .filter(point -> point.join().isInside())
            .count();
        return (double) 4 * pointInsideCount / n;
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
