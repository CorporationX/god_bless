package derschrank.sprint04.task14.bjstwo_49888;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Pi {
    private volatile long countOfPointsInside = 0;
    private volatile long countOfAllPoints = 0;

    public double calculatePi(int n) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            futures.add(
                    CompletableFuture
                            .supplyAsync(this::gereneratPoint)
                            .thenAcceptAsync(this::checkPoint)
                            .thenRunAsync(this::displayInfo)
            );
        }

        futures.forEach(CompletableFuture::join);

        displayInfo();
        return calculatePi(countOfPointsInside, countOfAllPoints);
    }

    public double calculatePi(long inside, long all) {
        return 4.0 * inside / all;
    }

    public Point gereneratPoint() {
        Random rnd = ThreadLocalRandom.current();
        return new Point(rnd.nextDouble(), rnd.nextDouble());
    }

    private void checkPoint(Point point) {
        incrementCountOfAllPoints();
        if (point.isInsideCircle()) {
            incrementCountOfPointsInside();
        }
    }

    private void displayInfo() {
        long[] counts = getValueOfCounts();
        countOfPointsInside = counts[0];
        countOfAllPoints = counts[1];

        System.out.printf("[%d:%d] %f%n", countOfPointsInside, countOfAllPoints,
                calculatePi(countOfPointsInside, countOfAllPoints));
    }

    private synchronized void incrementCountOfAllPoints() {
        countOfAllPoints++;
    }

    private synchronized void incrementCountOfPointsInside() {
        countOfPointsInside++;
    }

    private synchronized long[] getValueOfCounts() {
        return new long[]{countOfPointsInside, countOfAllPoints};
    }
}
