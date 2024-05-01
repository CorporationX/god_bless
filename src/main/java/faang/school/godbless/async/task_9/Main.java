package faang.school.godbless.async.task_9;

import faang.school.godbless.async.task_9.model.Point;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int RADIUS = 1;
    private static final int NUMBERS_OF_POINTS = 200000;

    public static void main(String[] args) {
        System.out.println(calculatePi(NUMBERS_OF_POINTS));
    }

    public static double calculatePi(int n) {
        ExecutorService executor = Executors.newCachedThreadPool();
        long inside = IntStream
                .range(0, n)
                .parallel()
                .mapToObj(num -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(0, 1);
                    double y = ThreadLocalRandom.current().nextDouble(0, 1);
                    return new Point(x, y);
                }, executor))
                .filter(point -> {
                    try {
                        return (Math.pow(point.get().getX(), 2) + Math.pow(point.get().getY(), 2)) <= RADIUS * RADIUS;
                    } catch (ExecutionException | InterruptedException e) {
                        log.error(e.getMessage());
                        throw new RuntimeException();
                    }
                }).count();
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return 4.0 * inside / NUMBERS_OF_POINTS;
    }
}