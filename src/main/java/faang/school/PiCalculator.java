package faang.school;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class PiCalculator {
    private static final int POINTS_COUNT = 1101000;

    public static void main(String[] args) {
        var insidePoints = Stream.iterate(0, i -> i + 1)
                .limit(POINTS_COUNT)
                .map(i -> CompletableFuture.supplyAsync(() -> Point.getRandomPoint().isInside()))
                .toList();

        int insidePointsCount = (int) insidePoints.stream().map(futurePoint -> {
            try {
                return futurePoint.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).filter(isInside -> isInside).count();

        System.out.println(calculatePercents(insidePointsCount, POINTS_COUNT));
        System.out.println("Done");
    }

    private static double calculatePercents(int inside, int all) {
        return 4 * inside / (double) all;
    }
}
