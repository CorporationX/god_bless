package faang.school.godbless.picalculation;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class calculatePi {


    public double calculate(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(n, 8));
        List<CompletableFuture<Point>> points = makePoints(executorService,n);
        CompletableFuture.allOf(points.toArray(CompletableFuture[]::new)).join();
        executorService.shutdown();
        long inCircle = points.parallelStream().filter((i) -> {
            try {
                return inCircle(i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).count();
        try {
            executorService.awaitTermination(n, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (double) 4 * inCircle / n;

    }

    private boolean inCircle(Point i) {
        return Math.pow(i.getX(), 2) + Math.pow(i.getY(), 2) <= 1;
    }

    private List<CompletableFuture<Point>> makePoints(ExecutorService executorService, int n) {
        return IntStream.range(0, n).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(
                        () -> makePoint(), executorService))
                .toList();
    }

    private Point makePoint() {
        return new Point(ThreadLocalRandom.current().nextDouble(0.0, 1.0), ThreadLocalRandom.current().nextDouble(0.0, 1.0));
    }
}
