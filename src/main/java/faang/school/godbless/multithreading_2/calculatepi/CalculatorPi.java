package faang.school.godbless.multithreading_2.calculatepi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CalculatorPi {
    private final double lefBorder = 0;
    private final double rightBorder = 1;
    public double calculatePi(int n) {
        final AtomicInteger amountInsidePoints = new AtomicInteger();
        final AtomicInteger amountAllPoints = new AtomicInteger();

        amountAllPoints.set(n);
        List<CompletableFuture<Void>> calculators = Stream.iterate(0, i -> i + 1).limit(n)
                .map(i -> CompletableFuture.runAsync(() -> processPoint(amountInsidePoints)))
                .toList();
        CompletableFuture.allOf(calculators.toArray(new CompletableFuture[0])).join();

        return (double) 4 * amountInsidePoints.get() / amountAllPoints.get();
    }

    private void processPoint(AtomicInteger amountInsidePoints) {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        Point point = new Point(
                localRandom.nextDouble(lefBorder, rightBorder),
                localRandom.nextDouble(lefBorder, rightBorder)
        );

        if (Math.pow(point.x(), 2) + Math.pow(point.y(), 2) <= Math.pow(rightBorder - lefBorder, 2)) {
            amountInsidePoints.addAndGet(1);
        }
    }
}
