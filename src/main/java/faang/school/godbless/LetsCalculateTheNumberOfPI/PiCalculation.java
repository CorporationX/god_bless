package faang.school.godbless.LetsCalculateTheNumberOfPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class PiCalculation {
    private final AtomicInteger inside = new AtomicInteger(0);
    private final AtomicInteger all = new AtomicInteger(0);
    private static final int NUM_THREADS = 10;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);
    private final List<CompletableFuture<Void>> allCompletableFuturesList = new ArrayList<>();

    public double calculate(int numPoints) {
        generateAndCountPoints(numPoints);
        waitGeneratingAndCountingPoints();
        shutdownPiCalculation();
        double insideDouble = inside.get();
        double allDouble = all.get();
        return 4 * insideDouble / allDouble;
    }

    public void generateAndCountPoints(int numPoints) {
        int rootOfNumPoints = (int) pow(numPoints, 0.5);
        IntStream.range(0, rootOfNumPoints).forEach(integer -> {
            CompletableFuture<Void> partOfAllFuture = CompletableFuture.runAsync(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                IntStream.range(0, rootOfNumPoints)
                        .mapToObj(i -> new Point(random.nextDouble(1), random.nextDouble(1)))
                        .forEach(point -> {
                            if (pow(point.x(), 2) + pow(point.y(), 2) <= 1) {
                                inside.incrementAndGet();
                                all.incrementAndGet();
                            } else {
                                all.incrementAndGet();
                            }
                        });
            }, EXECUTOR);
            allCompletableFuturesList.add(partOfAllFuture);
        });
    }

    public void waitGeneratingAndCountingPoints() {
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(allCompletableFuturesList.toArray(new CompletableFuture[0]));
        allFutures.join();
    }

    public void shutdownPiCalculation() {
        EXECUTOR.shutdownNow();
    }
}
