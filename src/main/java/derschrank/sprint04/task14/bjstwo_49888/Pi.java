package derschrank.sprint04.task14.bjstwo_49888;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class Pi {
    long countOfPointsInside = 0;
    long countOfAllPoints = 0;

    public double calculatePi(int n) {
        List<CompletableFuture<Point>> futures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
              futures.add(CompletableFuture.supplyAsync(this::gereneratPoint));
        }

        futures.forEach(future -> {
            Point point = future.join();
            countOfAllPoints++;
            if (point.isInsideCircle()) {
                countOfPointsInside++;
            }

            System.out.printf("[%d:%d] %f%n", countOfPointsInside, countOfAllPoints,
                    calculatePi(countOfPointsInside, countOfAllPoints));
        });

        return calculatePi(countOfPointsInside, countOfAllPoints);
    }

    public Point gereneratPoint() {
        Random rnd = ThreadLocalRandom.current();
        return new Point(rnd.nextDouble(), rnd.nextDouble());
    }

    public double calculatePi(long inside, long all) {
        return 4.0 * inside / all;
    }
}
