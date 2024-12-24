package school.faang.task49885;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class FindingPi {
    private static final int SIDE_LENGTH_SQUARE = 1;
    private static final int MULTIPLIER_FOR_PI = 4;

    private final AtomicInteger allPoints = new AtomicInteger(0);
    private final AtomicInteger insidePoints = new AtomicInteger(0);

    public double calculatePi(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Число точек не может быть меньше 1");
        }

        CompletableFuture.runAsync(() -> IntStream.range(0, n)
                .forEach(i -> {
                    Point point = new Point(ThreadLocalRandom.current().nextDouble(SIDE_LENGTH_SQUARE),
                            ThreadLocalRandom.current().nextDouble(SIDE_LENGTH_SQUARE));
                    if (point.isInsideCircle()) {
                        insidePoints.getAndIncrement();
                    }
                    allPoints.getAndIncrement();
                })
        ).join();

        return (double) (MULTIPLIER_FOR_PI * insidePoints.intValue()) / allPoints.intValue();
    }
}
