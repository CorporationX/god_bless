package faang.school.godbless.PI;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    static ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    static int AMOUNT_POINTS = 100;
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        log.info("calculatePi 100 points -> {}", calculatePi(AMOUNT_POINTS));
        log.info("calculatePi 200 points -> {}", calculatePi(2 * AMOUNT_POINTS));
        log.info("calculatePi 300 points -> {}", calculatePi(3 * AMOUNT_POINTS));
        log.info("calculatePi 1_000_000 points -> {}", calculatePi(10000 * AMOUNT_POINTS));

        executorService.shutdown();
    }

    public static double generator() {
        return RANDOM.nextDouble(1.0);
    }

    public static boolean inside(Point point) {
        double x = point.x();
        double y = point.y();
        return x * x + y * y <= 1;
    }

    public static double calculatePi(int n) {
        long inside = IntStream.range(0, n)
                .parallel()
                .mapToObj(index -> CompletableFuture.supplyAsync(() -> {
                    double x = generator();
                    double y = generator();
                    return new Point(x, y);
                }, executorService))
                .map(futurePoint -> futurePoint.thenApply(Main::inside))
                .map(CompletableFuture::join)
                .filter(isInside -> isInside)
                .count();

        return (double) 4 * inside / n;


    }

    record Point(double x, double y) {
    }
}
