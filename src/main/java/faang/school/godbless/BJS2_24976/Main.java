package faang.school.godbless.BJS2_24976;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 8;
    private static final double PI_MULTIPLIER = 4.0;
    private static ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        System.out.println(calculatePi(10000000));
    }

    public static double calculatePi(int n) {
        AtomicInteger insideIncrement = new AtomicInteger(0);

        CompletableFuture<Void> futures = CompletableFuture
                .allOf(IntStream.rangeClosed(0, n)
                        .parallel()
                        .mapToObj(num -> CompletableFuture.runAsync(() -> {
                            double x = ThreadLocalRandom.current().nextDouble(0, 1);
                            double y = ThreadLocalRandom.current().nextDouble(0, 1);

                            if (x * x + y * y <= 1) {
                                insideIncrement.incrementAndGet();
                            }
                        }, executorService))
                        .toArray(CompletableFuture[]::new));

        futures.join();
        executorService.shutdown();

        return PI_MULTIPLIER * insideIncrement.get() / n;
    }
}
