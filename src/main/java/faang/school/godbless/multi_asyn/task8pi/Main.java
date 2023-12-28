package faang.school.godbless.multi_asyn.task8pi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        double pi = calculatePi(10000000);

        long endTime = System.currentTimeMillis();

        System.out.println("---------------------------------------------");
        System.out.println("Pi: " + pi);
        System.out.println("Time: " + (endTime - startTime) + " ms");
        System.out.println("---------------------------------------------");
    }

    static double calculatePi(int n) {
        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, 8));

        CompletableFuture[] futures = IntStream.range(0, n).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(
                        () -> {
                            double x = ThreadLocalRandom.current().nextDouble();
                            double y = ThreadLocalRandom.current().nextDouble();
                            return new Point(x, y);
                        },
                        service
                )
        ).toArray(CompletableFuture[]::new);

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures);
        long countInside = allDone.thenApply(x -> Arrays.stream(futures)
                        .map(future -> (Point) future.join())
                        .filter(Point::isInside)
                        .count())
                .join();

        service.shutdown();
        return 4.0 * countInside / n;
    }

}
