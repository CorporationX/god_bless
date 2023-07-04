package faang.school;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class PiCalculator {
    private static final int POINTS_COUNT = 111000;

    public static void main(String[] args) {
        var insidePoints = Stream.iterate(0, i -> i + 1)
                .limit(POINTS_COUNT)
                .map(i -> CompletableFuture.supplyAsync(() -> new Point().isInside()))
                .toList();

        var res = CompletableFuture.allOf(insidePoints.toArray(CompletableFuture[]::new));
        res.thenRun(() -> {
            var percent = calculatePercents(insidePoints.stream().filter(i -> {
                try {
                    return i.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).toList().size(), POINTS_COUNT);
            System.out.println(percent);
        }).join();
    }

    private static double calculatePercents(int inside, int all) {
        return 4 * inside / (double) all;
    }
}
