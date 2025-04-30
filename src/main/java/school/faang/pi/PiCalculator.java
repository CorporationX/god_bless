package school.faang.pi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.pi.ThreadPoolProvider.executor;

@Slf4j
public class PiCalculator {
    private AtomicInteger inside = new AtomicInteger(0);
    private final static double MIN_COORDINATES = 0.0;
    private final static double MAX_COORDINATES = 1.0;

    public double calculateNumberPi(int numberOfDots) {
        if (numberOfDots <= 0) {
            throw new IllegalArgumentException("Количество точек должно быть > 0");
        }
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfDots; i++) {
            futures.add(CompletableFuture.supplyAsync(() -> new Point(getRandomNumBetween0And1(),
                            getRandomNumBetween0And1()), executor)
                    .thenAccept(this::incrementInsideIfTrue));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.debug("All dots generated and assessed");
        return getResultOfPi(numberOfDots);
    }

    private double getRandomNumBetween0And1() {
        return ThreadLocalRandom.current().nextDouble(MIN_COORDINATES, MAX_COORDINATES);
    }

    private void incrementInsideIfTrue(Point point) {
        if (point.isInsideCircle()) {
            inside = new AtomicInteger(inside.incrementAndGet());
        }
    }

    private double getResultOfPi(int numberOfDots) {
        return 4 * inside.get() / (double) numberOfDots;
    }
}
