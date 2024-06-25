package faang.school.godbless.multithreading_async.task_9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

public class PiCalculator {
    public double calculatePi(int n, ExecutorService executor) {
        long pointInsideCount = IntStream.range(0, n).parallel()
            .mapToObj(index -> CompletableFuture.supplyAsync(Point::new, executor))
            .filter(point -> point.join().isInside())
            .count();
        return (double) 4 * pointInsideCount / n;
    }
}
