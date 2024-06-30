package faang.school.godbless.multithreading.pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static double calculatePiParallel(long totalPoints){
        long pointsInsideCircle = Stream.generate(() -> new Point(
                        ThreadLocalRandom.current().nextDouble(0, 1),
                        ThreadLocalRandom.current().nextDouble(0, 1)))
                .limit(totalPoints)
                .parallel()
                .filter(point -> Math.pow(point.x(), 2) + Math.pow(point.y(), 2) <= 1)
                .count();

        return  4.0 * pointsInsideCircle / totalPoints;
    }

    public static double calculatePiAsync(long totalPoints) throws ExecutionException, InterruptedException {
        int numThreads = Runtime.getRuntime().availableProcessors();

        var completableFutureList = IntStream.range(0, numThreads)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    long pointsInsideCircle = 0;
                    for (int j = 0; j < totalPoints / numThreads; j++) {
                        double x = ThreadLocalRandom.current().nextDouble(0, 1);
                        double y = ThreadLocalRandom.current().nextDouble(0, 1);
                        if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                            pointsInsideCircle++;
                        }
                    }
                    return pointsInsideCircle;
                }))
                .toList();

        long totalPointsInsideCircle = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]))
                .thenApply(v -> completableFutureList.stream()
                        .mapToLong(CompletableFuture::join)
                        .sum())
                .get();

        return 4.0 * totalPointsInsideCircle / totalPoints;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long totalPoints = 1_000_000_000L;

        var beginParallel = System.currentTimeMillis();
        System.out.println("Estimated value of PI: " + calculatePiParallel(totalPoints));
        var endParallel = System.currentTimeMillis();
        System.out.println("Time calculatePiParallel: " + (endParallel - beginParallel));

        System.out.println("=========================");

        var beginAsync = System.currentTimeMillis();
        System.out.println("Estimated value of PI: " + calculatePiAsync(totalPoints));
        var endAsync = System.currentTimeMillis();
        System.out.println("Time calculatePiAsync: " + (endAsync - beginAsync));
    }
}
