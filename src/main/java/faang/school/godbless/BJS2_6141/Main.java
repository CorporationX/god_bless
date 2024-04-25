package faang.school.godbless.BJS2_6141;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static final double RADIUS = 1;
    public static AtomicInteger allInsidePoints = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        System.out.println(1);
        System.out.println(calculatePi(1000000));
    }

    static double calculatePi(int n) throws InterruptedException {
        // Берём минимум, что бы не создать слишком много потоков
        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, 8));

        IntStream.range(0, n).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(() ->
                        new Point(
                                ThreadLocalRandom.current().nextDouble(0.0, 1.0),
                                ThreadLocalRandom.current().nextDouble(0.0, 1.0)
                        ), service
                ).thenAccept(result -> {
                    if (isInside(result)) {
                        allInsidePoints.addAndGet(1);
                    }
                })
        ).forEach(CompletableFuture::join);
        service.shutdown();
        service.awaitTermination(2, TimeUnit.SECONDS);
        return (double) 4.0 * allInsidePoints.get() / n;
    }

    private static boolean isInside(Point point) {
        return (point.getX() * point.getX() + point.getY() * point.getY()) <= (RADIUS * RADIUS);
    }
}
