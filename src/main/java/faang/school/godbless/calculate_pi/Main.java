package faang.school.godbless.calculate_pi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int MAX_THREAD_POOL_SIZE = 1000;
    private static final int R = 1;
    private static final AtomicInteger inside = new AtomicInteger();
    private static final AtomicInteger all = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println(calculatePi(10000000));
        System.out.println(inside);
        System.out.println(all);
    }

    public static double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(MAX_THREAD_POOL_SIZE, n));
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        IntStream.range(0, n).forEach(i ->
                futures.add(
                        CompletableFuture.supplyAsync(() ->
                                new Point(
                                        ThreadLocalRandom.current().nextDouble(0, 1),
                                        ThreadLocalRandom.current().nextDouble(0, 1)
                                ), executorService
                        ).thenAccept(result -> {
                            boolean isInside = isInsideCircle(result);
                            if (isInside) {
                                inside.addAndGet(1);
                            }
                            all.addAndGet(1);
                        })
                )
        );

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();

        return (double) (4 * inside.get()) / all.get();
    }

    public static boolean isInsideCircle(Point point) {
        return Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(R, 2);
    }
}