package school.faang.godbless.bjs2_38750;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class PiCalculations {
    private static final int WAIT_TIME = 20000;
    private static final int MIN_POINTS = 100;
    private static final int MAX_POINTS = 10000000;
    private static final double MIN_COORDINATE = -1.0;
    private static final double MAX_COORDINATE = 1.0;
    private static final ExecutorService pool = Executors.newFixedThreadPool(8);

    public static void main(String[] args) throws InterruptedException {
        for (int i = MIN_POINTS; i <= MAX_POINTS; i *= 10) {
            long startTime = System.currentTimeMillis();
            double pi = calculatePi(i);
            log.info("Number of points = {} PI = {} time = {} ms", i, pi, System.currentTimeMillis() - startTime);
        }
        pool.shutdown();
    }

    private static double calculatePi(int n) throws InterruptedException {
        PointsCounter pointsCounter = new PointsCounter(n);
        IntStream.range(0, n).forEach(i ->
                CompletableFuture.runAsync(() -> {
                            Random random = ThreadLocalRandom.current();
                    double x = random.nextDouble(MIN_COORDINATE, MAX_COORDINATE);
                    double y = random.nextDouble(MIN_COORDINATE, MAX_COORDINATE);
                            Point randomPoint = new Point(x, y);
                            pointsCounter.addPoint(randomPoint.isInsideCircle());
                        }, pool
                ));
        pointsCounter.waitForAllReachesValue(n);
        return 4 * ((double) pointsCounter.getInside() / pointsCounter.getAll());
    }

    @Getter
    @RequiredArgsConstructor
    private static class PointsCounter {
        private final int numberOfPoint;
        private int inside = 0;
        private int all = 0;

        public synchronized void addPoint(boolean isInside) {
            if (isInside) {
                inside++;
            }
            all++;
            notifyAll();
        }

        public synchronized void waitForAllReachesValue(int value) throws InterruptedException {
            while (all != value) {
                wait(WAIT_TIME);
            }
        }
    }
}
