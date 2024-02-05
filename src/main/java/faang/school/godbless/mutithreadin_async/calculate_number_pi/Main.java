package faang.school.godbless.mutithreadin_async.calculate_number_pi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    private static final AtomicInteger inside = new AtomicInteger();
    private static final int all = 10_000_000;

    public static void main(String[] args) {
        System.out.println(calculatePi(all));
    }

    static double calculatePi(int n) {
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(n, 8));

        ThreadLocalRandom localRandom = ThreadLocalRandom.current();

        List<CompletableFuture<Void>> futures = IntStream
                .rangeClosed(0, n)
                .parallel()
                .mapToObj(num -> CompletableFuture.runAsync(() -> {
                    double x = localRandom.nextDouble(0, 1);
                    double y = localRandom.nextDouble(0, 1);

                    if ((Math.pow(x, 2) + Math.pow(y, 2)) <= 1) {
                        inside.incrementAndGet();
                    }
                }, executor)).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();


        return 4.0 * inside.get() / all;
    }
}
