package school.faang.pi;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static school.faang.pi.ThreadPoolProvider.executor;

@Slf4j
@UtilityClass
public class PiCalculator {
    private static final double MIN_COORDINATES = 0.0;
    private static final double MAX_COORDINATES = 1.0;

    public double calculateNumberPi(int numberOfDots) {
        AtomicInteger inside = new AtomicInteger(0);

        if (numberOfDots <= 0) {
            throw new IllegalArgumentException("Количество точек должно быть > 0");
        }
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfDots; i++) {
            futures.add(CompletableFuture.supplyAsync(() -> new Point(getRandomNumBetween0And1(),
                            getRandomNumBetween0And1()), executor)
                    .thenAccept(point -> {
                        if (point.isInsideCircle()) {
                            inside.incrementAndGet();
                        }
                    }));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        log.debug("All dots generated and assessed");
        return getResultOfPi(numberOfDots, inside.get());
    }

    private double getRandomNumBetween0And1() {
        return ThreadLocalRandom.current().nextDouble(MIN_COORDINATES, MAX_COORDINATES);
    }

    private double getResultOfPi(int numberOfDots, int numberOfInsideDots) {
        return 4 * numberOfInsideDots / (double) numberOfDots;
    }
}
