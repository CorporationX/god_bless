package faang.school.godbless.async.pi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static final int POINTS_AMOUNT = 20_000_000;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<CompletableFuture<Void>> points = new ArrayList<>();

        log.info("Starting collecting points.");

        AtomicInteger inCircleAmount = new AtomicInteger(0);

        for (int i = 0; i < POINTS_AMOUNT; i++) {
            CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> {
                        var x = ThreadLocalRandom.current().nextDouble(0, 1);
                        var y = ThreadLocalRandom.current().nextDouble(0, 1);

                        return new Point(x, y);
                    }, threadPool)
                    .thenAccept(point -> {
                        if (point.isInCircle(1)) {
                            inCircleAmount.incrementAndGet();
                        }
                    });
            points.add(task);
        }

        threadPool.shutdown();

        CompletableFuture.allOf(points.toArray(new CompletableFuture[0])).join();


        double piValue = 4d * inCircleAmount.get() / POINTS_AMOUNT;

        log.info("Calculated pi value - " + piValue);
    }
}
