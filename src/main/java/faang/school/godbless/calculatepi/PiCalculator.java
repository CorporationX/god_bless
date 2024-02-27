package faang.school.godbless.calculatepi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PiCalculator {

    public double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<CompletableFuture<Point>> points = getPoints(executorService, n);
        waitFutures(points);
        long insideCount = getSatisfyFromFutures(points, this::isInCircle);

        executorService.shutdown();
        awaitTermination(executorService, 5L);
        return (double) (4 * insideCount) / n;
    }

    private List<CompletableFuture<Point>> getPoints(ExecutorService executorService, int n) {
        return IntStream.range(0, n)
                .parallel()
                .mapToObj(i -> CompletableFuture.supplyAsync(this::getNewPoint, executorService))
                .toList();
    }

    private Point getNewPoint() {
        double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
        double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
        return new Point(x, y);
    }

    private long getSatisfyFromFutures(List<CompletableFuture<Point>> points, Predicate<Point> condition) {
        return points.stream()
                .map(this::futureGet)
                .filter(condition)
                .count();
    }

    private boolean isInCircle(Point point) {
        return Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= 1;
    }

    private <T> T futureGet(CompletableFuture<T> future) {
        try {
            return future.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void waitFutures(List<CompletableFuture<T>> futures) {
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
    }

    private void awaitTermination(ExecutorService executorService, Long minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
