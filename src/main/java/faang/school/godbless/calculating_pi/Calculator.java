package faang.school.godbless.calculating_pi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {
    private static final int ALL_POINTS = 1000;
    private static final AtomicInteger insidePoints = new AtomicInteger();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        calculatePi(executorService);

        executorService.shutdown();
    }

    public static void calculatePi(ExecutorService executorService) {
        Stream<CompletableFuture<Void>> futurePointStream =
                IntStream.range(0, ALL_POINTS).mapToObj(i -> CompletableFuture.runAsync(() -> {
                            double x = ThreadLocalRandom.current().nextDouble(0, 1.0);
                            double y = ThreadLocalRandom.current().nextDouble(0, 1.0);
                            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                                insidePoints.incrementAndGet();
                            }
                        },
                        executorService));

        List<CompletableFuture<Void>> futurePointList = futurePointStream.toList();

        CompletableFuture<Void> allOfCompletableFuture =
                CompletableFuture.allOf(futurePointList.toArray(CompletableFuture[]::new));

        allOfCompletableFuture.thenRun(() -> System.out.println(4.0 * insidePoints.get() / ALL_POINTS)).join();

        executorService.shutdown();
    }
}
