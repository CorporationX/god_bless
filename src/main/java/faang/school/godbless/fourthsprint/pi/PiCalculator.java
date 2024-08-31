package faang.school.godbless.fourthsprint.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PiCalculator {
    private final static int NUM_POINTS = Integer.MAX_VALUE;
    private final static int NUM_TASKS = 8;

    public CompletableFuture<Double> calculatePi(int n) {
        List<CompletableFuture<Long>> futures = new ArrayList<>();
        int pointsPerTask = n / NUM_TASKS;

        for (int i = 0; i < NUM_TASKS; i++) {
            CompletableFuture<Long> future = CompletableFuture.supplyAsync(() ->
                    IntStream.range(0, pointsPerTask)
                            .mapToObj(iteration -> generateRandomPoint())
                            .filter(Point::isInsideCircle)
                            .count()
            );
            futures.add(future);
        }

        CompletableFuture<Long> totalInsideCircle = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .mapToLong(CompletableFuture::join)
                        .sum()
                );

        return totalInsideCircle.thenApply(insideCircle -> 4.0 * insideCircle / n);
    }

    private Point generateRandomPoint() {
        double x = ThreadLocalRandom.current().nextDouble();
        double y = ThreadLocalRandom.current().nextDouble();
        return new Point(x, y);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PiCalculator calculator = new PiCalculator();
        calculator.calculatePi(NUM_POINTS)
                .thenAccept(pi -> System.out.println("Calculated value of Pi: " + pi))
                .join();
    }
}
