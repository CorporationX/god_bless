package school.faang.calculatenumberpi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PiCalculator {

    public static double calculatePi(int numberOfPoints) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        long pointsInsideCircle = IntStream.range(0, numberOfPoints)
                .parallel()
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                    double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                    Point point = new Point(x, y);
                    return point.isInsideCircle();
                }, executorService))
                .map(CompletableFuture::join)
                .filter(isInside -> isInside)
                .count();

        executorService.shutdown();

        return 4.0 * pointsInsideCircle / numberOfPoints;
    }
}

