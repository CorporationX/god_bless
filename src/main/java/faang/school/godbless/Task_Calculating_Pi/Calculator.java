package faang.school.godbless.Task_Calculating_Pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Calculator {

    private final static List<Point> circlePoints = new ArrayList<>();
    private final static List<Point> allPoints = new ArrayList<>();

    public static double calculatePi(int n) {
        int k = getThreadNumber(n);
        ExecutorService service = Executors.newFixedThreadPool(k);
        AtomicInteger inside = new AtomicInteger(0);
        AtomicInteger all = new AtomicInteger(0);
        IntStream.range(0, k).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(
                        () -> {
                            double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                            double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                            return new Point(x, y);
                        },
                        service
                )
        ).map(
                cf -> cf.thenAccept(
                        point -> {
                            all.incrementAndGet();
                            if (point.isInside()) {
                                inside.incrementAndGet();
                            }
                        }
                )
        ).forEach(CompletableFuture::join);
        service.shutdown();
        return 4.0 * inside.get() / all.get();
    }

    public static int getThreadNumber(int n) {
        if (n < 6) return 8;
        else return Math.min(n, 8);
    }
}
