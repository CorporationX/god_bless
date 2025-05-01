package school.faang.pi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PointService {
    private static final int FIXED_THREAD = 100;

    public static void calculate(int n) throws ExecutionException, InterruptedException {

        AtomicInteger inside = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(FIXED_THREAD);

        List<CompletableFuture<Point>> completableFutureList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            CompletableFuture<Point> future = CompletableFuture.supplyAsync(() -> {
                double x = ThreadLocalRandom.current().nextDouble();
                double y = ThreadLocalRandom.current().nextDouble();
                Point point = new Point(x, y);

                if (point.isInsideCircle()) {
                    inside.incrementAndGet();
                }

                return point;
            }, service);
            completableFutureList.add(future);
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(
                completableFutureList.toArray(new CompletableFuture[0])
        );

        CompletableFuture<Double> atomicIntegerCompletableFuture =
                voidCompletableFuture.thenApply(v -> 4.0 * inside.get() / n);
        service.shutdown();

        double pi = atomicIntegerCompletableFuture.get();
        log.info("число pi - {}", pi);
    }
}
